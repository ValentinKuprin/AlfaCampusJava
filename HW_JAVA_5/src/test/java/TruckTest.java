import details.Engine;
import exception.NoSuchQualificationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.Truck;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {
    private static Truck truck;

    private final String FILE_PATH = "src/main/resources/TruckInfo.txt";
    private final String WRONG_FILE_PATH = "src/main/resources/TruckInf.txt";

    @BeforeAll
    static void setCar() {
        truck = new Truck("Truck",
                8000,
                new Driver("Иванов Иван Иванович", 10, 600),
                new Engine(900, "GM"),
                30000);
    }

    @Test
    void carStartShouldReturnString() throws NoSuchQualificationException {
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
        String errorMessage = "";
        assertEquals("Truck info:\nType: Truck; Weight: 8000; Engine manufacturer: GM; Engine power: 900; loadCapacity: 30000", truck.toString(), "Проверь toString на соответствие формату");
        try {
            errorMessage = Files.readString(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Где то ошибка");
        }
        assertEquals("Truck info:\nType: Truck; Weight: 8000; Engine manufacturer: GM; Engine power: 900; loadCapacity: 30000", errorMessage, "Проверь toString на соответствие формату");

    }

    @Test
    void startWithNegativeDriverExpirienceIncorectFile() {
        assertDoesNotThrow(() -> truck.writeTrackInfoToFile("Тест", WRONG_FILE_PATH));
    }
}
