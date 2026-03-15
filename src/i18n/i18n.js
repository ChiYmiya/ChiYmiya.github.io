import zhCN from "../i18n/language/Zh-CN.json";
import en from "../i18n/language/en.json";
import ja from "../i18n/language/ja.json";

// サポート対象の言語コード
const SUPPORTED_LANGS = new Set(["ja", "en", "zh-CN"]);
const STORAGE_KEY = "preferred-language";
const LANG_MESSAGES = {
  ja: ja.ja,
  en: en.en,
  "zh-CN": zhCN["zh-CN"],
};

/**
 * 言語を切り替える関数
 * @param {string} lang - 切り替える言語(ja, en, zh-CN)
 */
function switchLang(lang) {
  const nextLang = normalizeLang(lang);
  const messages = LANG_MESSAGES[nextLang];
  const elements = document.querySelectorAll("[data-i18n]");

  elements.forEach((el) => {
    const key = el.dataset.i18n;
    const value = getValue(messages, key);

    if (typeof value === "string") {
      el.textContent = value;
    }
  });

  document.documentElement.lang = nextLang;
}

/**
 * オブジェクトから値を取得する関数
 * @param {object} obj - Jsonオブジェクト
 * @param {string} path - 値を取得するパス
 * @returns {string} 取得した値
 */
function getValue(obj, path) {
  return path.split(".").reduce((acc, item) => acc && acc[item], obj);
}

// 不正な言語指定はデフォルトの日本語に寄せる
function normalizeLang(lang) {
  if (typeof lang !== "string") {
    return "ja";
  }

  const normalized = lang.toLowerCase();

  if (normalized === "jp" || normalized === "ja") {
    return "ja";
  }

  if (normalized === "en") {
    return "en";
  }

  if (normalized === "cn" || normalized === "zh" || normalized === "zh-cn") {
    return "zh-CN";
  }

  return "ja";
}

// ブラウザ設定から ja / en / zh-CN を判定する
function detectBrowserLang() {
  const browserLangs = navigator.languages?.length
    ? navigator.languages
    : [navigator.language];

    
  for (const browserLang of browserLangs) {
    const normalized = browserLang?.toLowerCase() ?? "";
    

    if (normalized.startsWith("ja")) {
      return "ja";
    }

    if (normalized.startsWith("en")) {
      return "en";
    }

    if (normalized.startsWith("zh") || normalized.startsWith("cn")) {
      return "zh-CN";
    }
  }

  return "ja";
}

// ユーザーが手動選択した言語を保存する
function savePreferredLang(lang) {
  localStorage.setItem(STORAGE_KEY, normalizeLang(lang));
}

// 保存済みの言語設定を取得する
function getStoredLang() {
  return normalizeLang(localStorage.getItem(STORAGE_KEY));
}

// 初回表示時は保存済み設定を優先し、なければブラウザ言語を使う
function initI18n() {
  const storedLang = localStorage.getItem(STORAGE_KEY);
  switchLang(storedLang ? getStoredLang() : detectBrowserLang());
}

// 言語切り替えボタン
document
  .getElementById("ja-btn")
  ?.addEventListener("click", () => {
    switchLang("ja");
    savePreferredLang("ja");
  });

document
  .getElementById("en-btn")
  ?.addEventListener("click", () => {
    switchLang("en");
    savePreferredLang("en");
  });

document
  .getElementById("zh-cn-btn")
  ?.addEventListener("click", () => {
    switchLang("zh-CN");
    savePreferredLang("zh-CN");
  });

const navWrap = document.getElementById("header-nav-wrap");
const langToggleBtn = document.getElementById("lang-toggle-btn");

// モバイル用の言語メニューを閉じる
function closeLangMenu() {
  if (!navWrap || !langToggleBtn) return;
  navWrap.classList.remove("is-open");
  langToggleBtn.setAttribute("aria-expanded", "false");
}

// モバイル用の言語メニュー開閉
if (navWrap && langToggleBtn) {
  langToggleBtn.addEventListener("click", (event) => {
    event.stopPropagation();
    const isOpen = navWrap.classList.toggle("is-open");
    langToggleBtn.setAttribute("aria-expanded", String(isOpen));
  });

  ["ja-btn", "en-btn", "zh-cn-btn"].forEach((id) => {
    const el = document.getElementById(id);
    if (!el) return;
    el.addEventListener("click", closeLangMenu);
  });

  document.addEventListener("click", (event) => {
    if (!navWrap.contains(event.target)) {
      closeLangMenu();
    }
  });

  window.addEventListener("resize", () => {
    if (window.innerWidth >= 1024) {
      closeLangMenu();
    }
  });
}

// DOMの準備完了後に初期言語を適用する
if (document.readyState === "loading") {
  document.addEventListener("DOMContentLoaded", initI18n, { once: true });
} else {
  initI18n();
}
