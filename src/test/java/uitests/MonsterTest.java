package uitests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MonsterPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class MonsterTest {



    @Test
    public void monsterPageTest() {

        //System.setProperty("selenide.browser","firefox");
        //Configuration.browser = "firefox";
        //Configuration.browser = "safari";
        // mvn clean install -Dselenide.browser=chrome
        //Configuration.headless = true;
        //Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://monster.com";
        Configuration.remote="http://localhost:4444/wd/hub";

        open("https://monster.com");
        getWebDriver().manage().window().maximize();
        MonsterPage monsterPage = new MonsterPage();
        //Element list size
        monsterPage.selectLanguageList.shouldHave(size(19));
        List<String> currentLanguages = monsterPage.selectLanguageList.texts();
        System.out.println("List of Language: " + currentLanguages);
        List<String> currentLanguagesurl = monsterPage.selectLanguageListURL.attributes("href");
        System.out.println("List of Language URL: " + currentLanguagesurl);
        monsterPage.searchField.val("Software QA");
        assertThat(monsterPage.selectLanguageListTexts).as("Compare Supporting Language list").containsExactlyInAnyOrderElementsOf(currentLanguages);
        boolean containsSubList1 = currentLanguages.containsAll(monsterPage.selectLanguageListTexts);
        System.out.println("List of Language Compare: " + containsSubList1);
        monsterPage.selectLanguageList.shouldHave(CollectionCondition.texts(monsterPage.selectLanguageListTexts));
        //monsterPage.selectLanguageMenu.selectOption("Belgium (English)");
        System.out.println("Select URLe: " + WebDriverRunner.url());
        $(By.partialLinkText("Career")).shouldBe(Condition.visible);
        sleep(10000);
    }

    @Test
    public void browserNavigationTest() {

        open("https://monster.com");
        System.out.println("First: " + title());

        open("https://google.com");
        System.out.println("Second: " + title());

        back();
        System.out.println("Third: " + title());

        forward();
        System.out.println("Forth: " + title());

        sleep(3000);
        refresh();

    }
}
