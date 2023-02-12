import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void eachSetUp() {
        driver.get("http://qa-games.ru/");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(350);
        driver.close();
        driver.quit();
    }
}
