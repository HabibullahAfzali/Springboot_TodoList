import { createI18n } from "vue-i18n";
import English from "./locales/English.json";
import Farsi from "./locales/Farsi.json";
import Espanol from "./locales/Espanol.json";

function loadlocaleMessages() {
  return {
    en: English,
    fa: Farsi,
    es: Espanol,
  };
}

export default createI18n({
  locale: "en",
  fallbackLocale: "en",
  messages: loadlocaleMessages(),
});
