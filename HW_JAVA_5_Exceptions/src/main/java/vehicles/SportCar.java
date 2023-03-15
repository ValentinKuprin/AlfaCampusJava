package vehicles;

/* Требования:
1. Класс SportCar должен быть потомком класса Car
2. В классе должно быть приватное final поле int minimalDrivingExperience = 10
3. В классе должен быть реализован метод writeQualificationDriverInfoToFile:
Параметры:
String fileText
String fileName
Функция должна записывать переданную строку в файл, находящийся по пути
src/main/resources/<fileName>
Запись в файл должна быть реализована классом FileWriter, с помощью конструкции try-catch-finally
4. В классе должен быть переопределен метод start:
Если у водителя недостаточный стаж, метод start() должен сначала записать в файл DriverWithOutQualificationInfo.txt текст в соответствии с примером:
<ФИО водителя> недостаточно квалифицирован, требуемый стаж: <значение>, стаж водителя: <значение>,
а потом вернуть ошибку NoSuchQualificationException, которая в стектрейсе должна вывести тот же текст, что и записали в файл
Если у водителя со стажем все в порядке должен вернуть результат работы родительского метода start()

PS: Не забываем про super
 */

import Interfaces.WriteInfo;
import details.Engine;
import exception.NoSuchQualificationException;
import professions.Driver;

import java.io.FileWriter;
import java.io.IOException;

public class SportCar extends Car implements WriteInfo {
    private final int minimalDrivingExperience = 10;

    public SportCar(String type, int weight, Driver driver, Engine engine) {
        super(type, weight, driver, engine);
    }

    public void writeInfoToFile(String fileText, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(WriteInfo.FILE_PATH + fileName);
            writer.write(fileText);
            System.out.println("Файл записан успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл. \n" + e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия файла. \n" + e);
                }
            }
        }
    }

    @Override
    public String start() throws NoSuchQualificationException {
        if (getDriver().getDrivingExpirience() < minimalDrivingExperience) {
            String insufficientDrivingExperienceExceptionText = getDriver().getFio()
                    + " недостаточно квалифицирован, требуемый стаж: "
                    + minimalDrivingExperience + ", стаж водителя: " + getDriver().getDrivingExpirience();

            writeInfoToFile(insufficientDrivingExperienceExceptionText, "DriverWithOutQualificationInfo.txt");
            throw new NoSuchQualificationException(insufficientDrivingExperienceExceptionText);
        }

        return super.start();
    }
}
