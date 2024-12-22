package uitests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

public class GoogleTest {

    @Test
    public void googleSearch(){
        open("https://google.com");
        Boolean browser = WebDriverRunner.isChrome();
        System.out.println("Runs with Chrome: " + browser);
        assertThat(browser).as("Browser is Chrome").isTrue();

        String url = WebDriverRunner.url();
        System.out.println("Current URL: " + url);
        GooglePage googlePage = new GooglePage();
        googlePage.searchField.setValue("Selenide").pressEnter();
        url = WebDriverRunner.url();
        System.out.println("Current URL: " + url);
        assertThat(url).as("Search result page should have search keyword").contains("q=Selenide");
        googlePage.searchResultLogo.shouldBe(visible);
        $("h3").shouldHave(text("Selenide: concise UI tests in Java"));
        $(By.xpath("//h3[contains(text(),'Selenide: concise UI tests in Java')]")).should(be(visible));

    }

    @Test
    public void testMultipleElements() {
        List<String> expectedLinks = List.of("Home", "About", "Shop"); // Java 9
        // List<String> list = ["A", "B", "C"]; Java 7
        List<String> expectedLinks2 = asList("foo", "bar", "baz"); // Java 8
    }

}
