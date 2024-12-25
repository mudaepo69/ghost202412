package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SelenidePage {

    public final SelenideElement logoBrowserstack = $("div .sponsor a img[alt*='BrowserStack']");

}
