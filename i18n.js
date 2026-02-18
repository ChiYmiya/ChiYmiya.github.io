async function switchLang(lang) {
  const response = await fetch("./language.json");
  const dict = await response.json();

  const elements = document.querySelectorAll("[data-i18n]");

  elements.forEach((el) => {
    const key = el.dataset.i18n;
    el.textContent = getValue(dict[lang], key);
  });
}

function getValue(obj, path) {
  return path.split(".").reduce((acc, item) => acc && acc[item], obj);
}
