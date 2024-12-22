package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CommonPage {

    public void searchTextLink(String searchKeyword){
        $(By.partialLinkText(searchKeyword)).click();
    }

}
