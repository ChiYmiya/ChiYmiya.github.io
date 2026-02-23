import language from "./language.json";
/**
 * 言語を切り替える関数
 * @param {string} lang - 切り替える言語(jp, en, cn)
 */
async function switchLang(lang) {

  const elements = document.querySelectorAll("[data-i18n]");

  elements.forEach((el) => {
    const key = el.dataset.i18n;
    el.textContent = getValue(language[lang], key);
  });
}

/**
 * オブジェクトから値を取得する関数
 * @param {object} obj - オブジェクト
 * @param {string} path - 値を取得するパス
 * @returns {string} 値
 */
function getValue(obj, path) {
  return path.split(".").reduce((acc, item) => acc && acc[item], obj);
}
/**
 * 言語を切り替えるイベントリスナー
 */
document
  .getElementById("jp-btn")
  .addEventListener("click", () => {
    switchLang("jp")
  })

document
  .getElementById("en-btn")
  .addEventListener("click", () => {
    switchLang("en")
  })

document
  .getElementById("cn-btn")
  .addEventListener("click", () => {
    switchLang("cn")
  })
