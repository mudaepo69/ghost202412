package uitests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;
import pages.MonsterPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MonsterTest {



    @Test
    public void monsterPageTest() {
        Configuration.browser = "firefox";
        open("https://monster.com");
        MonsterPage monsterPage = new MonsterPage();
        monsterPage.selectLanguageList.shouldHave(size(19));
        List<String> currentLanguages = monsterPage.selectLanguageList.texts();
        System.out.println("List of Language: " + currentLanguages);
        monsterPage.searchField.val("Software QA");
        assertThat(monsterPage.selectLanguageListTexts).as("Compare Supporting Language list").containsExactlyInAnyOrderElementsOf(currentLanguages);
        boolean containsSubList1 = currentLanguages.containsAll(monsterPage.selectLanguageListTexts);
        System.out.println("List of Language Compare: " + containsSubList1);
        monsterPage.selectLanguageList.shouldHave(CollectionCondition.texts(monsterPage.selectLanguageListTexts));
        //monsterPage.selectLanguageMenu.selectOption("Belgium (English)");
        System.out.println("Select URLe: " + WebDriverRunner.url());

    }

}
