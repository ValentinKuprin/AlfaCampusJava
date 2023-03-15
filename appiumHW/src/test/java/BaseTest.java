import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

//    Указать свой путь для chromeDriver
//    private static final String CHROMEDRIVER_PATH = "C:\\Github\\AlfaCampus\\Campus\\appiumHW\\src\\main\\resources\\chromedriver.exe";

    public static AndroidDriver<MobileElement> driver;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "Pixel 6 API 29 Android 10");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("appPackage", "org.wikipedia");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        caps.setCapability("noReset", false);
//        caps.setCapability("chromedriverExecutable", CHROMEDRIVER_PATH); //TODO: закоментировать чтобы не поломало код если запустят не используя локальный драйвер
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
