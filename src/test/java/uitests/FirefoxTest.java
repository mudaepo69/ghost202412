package uitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MonsterPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({ TextReport.class})
public class FirefoxTest {

    @Test
    public void firefoxTest() {

        //Configuration.headless = true;
        //System.setProperty("selenide.browser", "firefox");
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        //Configuration.remote="http://localhost:4444/wd/hub";

        open("https://monster.com");
        getWebDriver().manage().window().maximize();

        System.out.println("Is Firefox Browser: " + WebDriverRunner.isFirefox());
        MonsterPage monsterPage = new MonsterPage();
        //Element list size
        monsterPage.selectLanguageList.shouldHave(size(19));
        List<String> currentLanguages = monsterPage.selectLanguageList.texts();
        System.out.println("List of Language: " + currentLanguages);
        List<String> currentLanguagesurl = monsterPage.selectLanguageListURL.attributes("href");
        System.out.println("List of Language URL: " + currentLanguagesurl);
        monsterPage.searchField.val("Software QA");
    }

    @Test
    public void firefoxHeadlessPageTest() {

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
//        WebDriverRunner.setWebDriver(driver);

        Configuration.browser = "firefox";
        Configuration.headless = true;
//        Configuration.browserSize = "1920x1080";
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setCapability("webSocketUrl", true);
//        Configuration.browserCapabilities = new DesiredCapabilities();
//        Configuration.browserCapabilities.setCapability("webSocketUrl", true);


        open("https://monster.com");
        getWebDriver().manage().window().maximize();

        System.out.println("Is Firefox Browser: " + WebDriverRunner.isFirefox());
        MonsterPage monsterPage = new MonsterPage();
        //Element list size
        monsterPage.selectLanguageList.shouldHave(size(19));
        List<String> currentLanguages = monsterPage.selectLanguageList.texts();
        System.out.println("List of Language: " + currentLanguages);
        List<String> currentLanguagesurl = monsterPage.selectLanguageListURL.attributes("href");
        System.out.println("List of Language URL: " + currentLanguagesurl);
        monsterPage.searchField.val("Software QA");
    }




}
