import details.Engine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.Car;

public class CarTest {
    private Car car;

    @BeforeAll
    void setCar() {
        car = new Car("Sedan",
                2000, 
                new Driver("Иванов Иван Иванович", 10),
                new Engine(200, "GM"));
    }

    @Test
    void carStartShouldReturnString() {
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
