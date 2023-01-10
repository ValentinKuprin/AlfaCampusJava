import details.Engine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.Truck;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {
    private Truck truck;

    @BeforeAll
    void setCar() {
        truck = new Truck("Truck",
                8000,
                new Driver("Иванов Иван Иванович", 10),
                new Engine(900, "GM"),
                30000);
    }

    @Test
    void carStartShouldReturnString() {
        assertEquals("поехали", truck.start(), "метод start() видимо не отнаследован от класса Car");
    }

    @Test
    void carStopShouldReturnString() {
        assertEquals("останавливаемся", truck.stop(), "метод stop() видимо не отнаследован от класса Car");
    }

    @Test
    void carTurnRightShouldReturnString() {
        assertEquals("поворот направо", truck.turnRight(), "метод turnRight() видимо не отнаследован от класса Car");
    }

    @Test
    void carTurnLeftShouldReturnString() {
        assertEquals("поворот налево", truck.turnLeft(), "метод turnLeft() видимо не отнаследован от класса Car");
    }

    @Test
    void toStringShouldReturnString() {
        assertEquals("Truck info:\nType: Truck; Weight: 8000; Engine manufacturer: GM; Engine power: 900; loadCapacity: 30000", truck.toString(), "Проверь toString на соответствие формату");
    }
}
