package driver.local;

import driver.IDriver;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static test.TestListener.LOGGER;

@Log4j2
public class LocalDriverManager implements IDriver {

    @Override
    public WebDriver createInstance(String browser) {
         WebDriver driver = null;

        try {
            // This custom condition is written because of render timeout bug in chromedriver
            if (browser.toUpperCase().equals("CHROME")) {
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver(options);
            } else {
                DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
                Class<?> driverClass = Class.forName(driverManagerType.browserClass());
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = (WebDriver) driverClass.newInstance();
            }
        } catch (IllegalAccessException | ClassNotFoundException e) {
            LOGGER.error("The class could not be found", e);
        } catch (InstantiationException e) {
            LOGGER.error("Problem during driver instantiation", e);
        }
        return driver;
    }
}
