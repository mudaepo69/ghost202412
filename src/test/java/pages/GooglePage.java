package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    public final SelenideElement searchField = $("textarea[name='q']");
    public final SelenideElement searchResultLogo = $("div .logo img");
    public final ElementsCollection searchResultList = $$("#ires li.g']");

}
