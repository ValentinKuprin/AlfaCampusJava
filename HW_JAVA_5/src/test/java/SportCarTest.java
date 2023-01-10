import details.Engine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.SportCar;

public class SportCarTest {
    private SportCar sportCar;

    @BeforeAll
    void setCar() {
        sportCar = new SportCar("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 10),
                new Engine(200, "GM"));
    }

    @Test
    void carStartShouldReturnString() {
        assertEquals("поехали", sportCar.start(), "Метод start() видимо не отнаследован от класса Car");
    }

    @Test
    void carStopShouldReturnString() {
        assertEquals("останавливаемся", sportCar.stop(), "метод stop() видимо не отнаследован от класса Car");
    }

    @Test
    void carTurnRightShouldReturnString() {
        assertEquals("поворот направо", sportCar.turnRight(), "метод turnRight() видимо не отнаследован от класса Car");
    }

    @Test
    void carTurnLeftShouldReturnString() {
        assertEquals("поворот налево", sportCar.turnLeft(), "метод turnLeft() видимо не отнаследован от класса Car");
    }

    @Test
    void startWithPositiveDriverExpirienceShouldReturnSuperStart() {
        assertEquals("поехали", sportCar.start(), "Метод start() видимо не отнаследован от класса Car");
    }

    @Test
    void startWithNegativeDriverExpirienceShouldReturnString() {
        sportCar = new SportCar("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 9),
                new Engine(200, "GM"));
        assertEquals("Иванов Иван Иванович недостаточно квалифицирован, требуемый стаж: 10, стаж водителя: 9", sportCar.start(), "Метод start() видимо не отнаследован от класса Car");
    }
    
}
