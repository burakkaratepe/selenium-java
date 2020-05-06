package test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import config.Configuration;
import driver.DriverFactory;
import driver.DriverManager;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

@Listeners({ExtentITestListenerClassAdapter.class, TestListener.class})
public abstract class BaseWeb {

    @BeforeSuite
    @Parameters("environment")
    public void setConfiguration(@Optional("dev") String environment) {
        String env = System.getenv("environment");
        ConfigFactory.setProperty("env", env == null ? environment : env);
    }

    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration.url());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postCondition() {
        DriverManager.quit();
    }
}
