package uitests;

import base.BaseTest;
import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MonsterPage;
import pages.SelenidePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ TextReport.class})
public class SelenideTest extends BaseTest {

    @Test
    public void firefoxRemotePageTest() {

        Configuration.browser = "firefox";
        //Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.remote="http://localhost:4444/wd/hub";

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
    public void multiWindowTest() {
        open("https://selenide.org/");
        SelenidePage selenidePage = new SelenidePage();
        selenidePage.logoBrowserstack.click();
        switchTo().window(1);
        sleep(3000);
        System.out.println("Current Page Title: " + title());
        closeWindow();
        switchTo().window(0);
        System.out.println("Current Page Title: " + title());
    }

    @Test
    public void webdriverTest() {
        open("https://google.com/");
        System.out.println("URL: " + WebDriverRunner.url());
        WebDriverRunner.clearBrowserCache();
        System.out.println("getAndCheck: "  + WebDriverRunner.getAndCheckWebDriver());
    }

    @Test
    public void alertTest() {
        open("https://google.com/");
        Alert alert = switchTo().alert();
        alert.getText();
        alert.accept();
        alert.dismiss();
    }

    @Test
    public void iframeTest() {
        open("https://google.com/");
        switchTo().frame($("iframe name"));
        switchTo().defaultContent();
    }

    @Test
    public void elementsTest() {
        open("https://monster.com");
        MonsterPage monsterPage = new MonsterPage();
        //ElementsCollection langLists = monsterPage.selectLanguageList;
        ElementsCollection allLinks = $$(By.tagName("a"));
        System.out.println("All Links size: " + allLinks.size());
//        for(SelenideElement lang : allLinks){
//            String langText = lang.getText();
//            String URL =lang.getAttribute("href");
//            System.out.println("Content, URL: " + langText +", "+URL);
//        }
        //allLinks.forEach(e -> System.out.println("Link Text : " + e.getText() +", " + e.getAttribute("href")));
        //allLinks.stream().filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println("Link Text : " + e.getText() +", " + e.getAttribute("href")));
        allLinks.last(10).stream().filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println("Link Text : " + e.getText() +", " + e.getAttribute("href")));

    }

    @Test
    public void selenideWaitTest() {
        // Implicit Wait setting is a Global setting and applies to all elements in the script
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Explicit wait is more intelligent, but can only be applied for specified elements.
        // explicit wait - to wait for the compose button to be click-able
        // WebDriverWait wait = new WebDriverWait(driver,30);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

        $("cssSelector").should(Condition.visible, Duration.ofSeconds(10));
        $("cssSelector").shouldBe(visible); //wait
        $("cssSelector").shouldHave(exactText("About")); //wait2

        actions().moveToElement($("cssSelector")).click().build().perform();
        $("cssSelector").should(Condition.checked);
        $("cssSelector").shouldBe(Condition.checked);
    }
}
