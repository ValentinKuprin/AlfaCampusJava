import details.Engine;
import exception.NoSuchQualificationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private static Car car;

    @BeforeAll
    static void setCar() {
        car = new Car("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 10, 600),
                new Engine(200, "GM"));
    }

    @Test
    void carStartShouldReturnString() throws NoSuchQualificationException {
        assertEquals("поехали", car.start(), "Метод start() в классе Car работает неправильно");
    }

    @Test
    void carStopShouldReturnString() {
        assertEquals("останавливаемся", car.stop(), "метод stop() в классе Car работает неправильно");
    }

    @Test
    void carTurnRightShouldReturnString() {
        assertEquals("поворот направо", car.turnRight(), "метод turnRight() в классе Car работает неправильно");
    }

    @Test
    void carTurnLeftShouldReturnString() {
        assertEquals("поворот налево", car.turnLeft(), "метод turnLeft() в классе Car работает неправильно");
    }
}
