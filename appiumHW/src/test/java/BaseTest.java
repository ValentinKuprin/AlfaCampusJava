import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command. Обязательный параметр
        caps.setCapability("deviceName", "Pixel 4 API 31 Vedroid 12");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("appPackage", "org.wikipedia");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
