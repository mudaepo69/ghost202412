package uitests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MonsterPage;
import pages.SelenidePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

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
        open("https://google.org/");
        System.out.println("URL: " + WebDriverRunner.url());
        WebDriverRunner.clearBrowserCache();
        System.out.println("getAndCheck: "  + WebDriverRunner.getAndCheckWebDriver());
    }

    @Test
    public void alertTest() {
        open("https://google.org/");
        Alert alert = switchTo().alert();
        alert.getText();
        alert.accept();
        alert.dismiss();
    }

    @Test
    public void iframeTest() {
        open("https://google.org/");
        switchTo().frame($("iframe name"));
        switchTo().defaultContent();
    }

    @Test
    public void loginName() throws MalformedURLException {
        open("https://google.org/", "", "admin", "pass");
        open(new URL("https://google.org/"), "", "admin", "pass");
        sleep(5000);
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
