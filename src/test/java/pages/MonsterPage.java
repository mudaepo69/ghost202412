package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MonsterPage {

    public final SelenideElement searchField = $("input[name='q']");
    public final SelenideElement selectLanguageMenu = $("footer ul[name='dropdown-ul']");
    public final ElementsCollection selectLanguageList = $$("footer li[name*='dropdown-item-']");
    public final ElementsCollection selectLanguageListURL = $$("footer li[name*='dropdown-item-'] a");
    public List<String> selectLanguageListTexts = List.of("Belgium (English)",
            "Belgique (Français)", "België (Nederlands)", "Canada (English)", "Canada (Français)",
            "Deutschland (Deutsch)", "España (Español)", "France (Français)", "Ireland (English)",
            "Italia (Italiano)", "Luxemburg (Deutsch)", "Luxembourg (English)", "Luxembourg (Français)",
            "Nederland (Nederlands)", "Österreich (Deutsch)", "Schweiz (Deutsch)", "Suisse (Français)",
            "Sverige (Svenska)", "United Kingdom (English)");

}
