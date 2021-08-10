package projectTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import project.browser.ConfigurationManager;
import project.browser.DriverManager;
import project.browser.TargetFactory;
import project.pages.LoginPage;
import project.util.AllureManager;

import static project.browser.ConfigurationManager.configuration;

@Listeners({TestListener.class})
public   class BaseTest {
    static LoginPage loginPage;

    @BeforeSuite
    public void beforeSuite() {

        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {

    }
}

