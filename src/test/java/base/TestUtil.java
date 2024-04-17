package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestUtil extends DataProviders {
    public WebDriver driver;
    private String browser, targetURL;
    private int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenTargetURL() {
        readConfig("src/test/resources/config.properties");
        setupDriver();
        //driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get(targetURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    private void readConfig(String pathToFile) {
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setupDriver() {
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }
    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
