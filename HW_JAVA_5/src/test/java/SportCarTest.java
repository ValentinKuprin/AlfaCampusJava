import details.Engine;
import exception.NoSuchQualificationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import professions.Driver;
import vehicles.SportCar;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SportCarTest {
    private static SportCar sportCar;
    private final String FILE_PATH = "src/main/resources/DriverWithOutQualificationInfo.txt";
    private final String WRONG_FILE_PATH = "src/main/resources/DriverWithOutQualification.txt";

    @BeforeAll
    static void setCar() {
        sportCar = new SportCar("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 10, 600),
                new Engine(200, "GM"));
    }

    @Test
    void carStartShouldReturnString() throws NoSuchQualificationException {
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
    void startWithPositiveDriverExpirienceShouldReturnSuperStart() throws NoSuchQualificationException {
        assertEquals("поехали", sportCar.start(), "Метод start() видимо не отнаследован от класса Car");
    }

    @Test
    void startWithNegativeDriverExpirienceShouldReturnGoodException() {
        SportCar sportCar;
        String errorMessage = "";
        sportCar = new SportCar("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 0, 400),
                new Engine(200, "GM"));
        NoSuchQualificationException exception = assertThrows(NoSuchQualificationException.class, sportCar::start);
        try {
            errorMessage = Files.readString(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Где то ошибка");
        }
        assertEquals("Иванов Иван Иванович недостаточно квалифицирован, требуемый стаж: 10, стаж водителя: 0", errorMessage, "В файл записана неверная информация");
        assertEquals("Иванов Иван Иванович недостаточно квалифицирован, требуемый стаж: 10, стаж водителя: 0", exception.getMessage(), "Ошибка выводит неверный текст, проверьте текст ошибки");
    }

    @Test
    void startWithNegativeDriverExpirienceIncorectFile() {
        SportCar sportCar;
        sportCar = new SportCar("Sedan",
                2000,
                new Driver("Иванов Иван Иванович", 0, 400),
                new Engine(200, "GM"));
        assertDoesNotThrow(() -> sportCar.writeQualificationDriverInfoToFile("Тест", WRONG_FILE_PATH));
    }
}
