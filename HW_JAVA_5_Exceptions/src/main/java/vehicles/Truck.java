package vehicles;

/* Требования:
1. Класс Truck должен быть потомком класса Car
2. В классе должно быть приватное поле int loadCapacity
3. В классе должен быть реализован метод writeTrackInfoToFile:
Параметры:
String fileText
String fileName
Функция должна записывать переданную строку в файл, находящийся по пути
src/main/resources/<fileName>
Запись в файл должна быть реализована классом FileWriter, с помощью конструкции try-with-resources
4. В классе должен быть переопределен метод toString который сначала записывает в файл TruckInfo.txt, а потом возвращает строку с информацией о грузовике в соответствии с примером:
Truck info:
Type: <значение>; Weight: <значение>; Engine manufacturer: <значение>; Engine power: <значение>; loadCapacity: <значение>

PS: Не забываем про super
 */

import Interfaces.WriteInfo;
import details.Engine;
import professions.Driver;

import java.io.FileWriter;
import java.io.IOException;

public class Truck extends Car implements WriteInfo {
    private final int loadCapacity;

    public Truck(String type, int weight, Driver driver, Engine engine, int loadCapacity) {
        super(type, weight, driver, engine);
        this.loadCapacity = loadCapacity;
    }

    public void writeInfoToFile(String fileText, String fileName) {
        try (FileWriter writer = new FileWriter(WriteInfo.FILE_PATH + fileName)) {
            writer.write(fileText);
            System.out.println("Файл записан успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл. \n" + e);
        }
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        String truckInfo = "Truck info:\n"
                + "Type: " + getType()
                + "; Weight: " + getWeight()
                + "; Engine manufacturer: " + getEngine().getManufacturer()
                + "; Engine power: " + getEngine().getPower()
                + "; loadCapacity: " + getLoadCapacity();

        writeInfoToFile(truckInfo, "TruckInfo.txt");

        return truckInfo;
    }
}