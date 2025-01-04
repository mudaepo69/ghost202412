package base;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // @BeforeClass => @Before => @Test => @After => @AfterClass


//    private WebDriver driver;
//    private DesiredCapabilities desiredCapabilities;
//
//    @BeforeClass
//    public void init(String browserName) throws MalformedURLException {
//        desiredCapabilities = new DesiredCapabilities();
//        if (browserName.equals("chrome")) {
//            desiredCapabilities.setCapability("browserName", "chrome");
//        } else if (browserName.equals("firefox")) {
//            desiredCapabilities.setCapability("browserName", "firefox");
//        }
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
//        setWebDriver(driver);
//        open("https://www.lambdatest.com/");
//        driver.manage().window().maximize();
//    }

    @BeforeClass
    public void beforeClassSetup() {
        SelenideLogger.addListener("Text Report", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
        System.out.println("My Before Class setting Selenide logger ...");
    }



}
