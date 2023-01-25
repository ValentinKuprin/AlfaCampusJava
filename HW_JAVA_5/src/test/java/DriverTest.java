import org.junit.jupiter.api.Test;
import professions.Driver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {


    @Test
    void checkThatMileageInYearDoesNotThrow() {
        assertDoesNotThrow(() -> new Driver("Иванов Иван Иванович", 0, 400));
    }

    @Test
    void checkThatMileageInYearEqualMileage() {
        Driver driver = new Driver("Иванов Иван Иванович", 0, 400);
        assertEquals(driver.getMileageInYear(), 400, "Неправильная обработка ошибки при стаже 0 лет при вычисление километража в год");

    }
}
