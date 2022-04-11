package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    protected static WebDriver driver;
    @BeforeScenario
    public void initializeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get("https://www.enuygun.com/");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @AfterScenario
    public static void quit()  {
        driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        driver.quit();

    }
}
