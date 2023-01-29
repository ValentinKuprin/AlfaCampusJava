package vehicles;

/* Требования:
1. Класс должен содержать следующие поля
String type
int weight
Driver driver
Engine engine
Поля должны быть приватными
2. В классе должен быть конструктор, который инициализирует все поля класса
3. В классе должны быть реализованы методы:
start() - возвращает строку "поехали"
stop() - возвращает строку "останавливаемся"
turnRight() - возвращает строку "поворот направо"
turnLeft() - возвращает строку "поворот налево"

PS: При необходимости получить доступ к приватным полям класса использовать геттеры/сеттеры
 */

import details.Engine;
import exception.NoSuchQualificationException;
import professions.Driver;

public class Car{
    private final String type;
    private final int weight;
    private final Driver driver;
    private final Engine engine;

    public Car(String type, int weight, Driver driver, Engine engine) {
        this.type = type;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public String start() throws NoSuchQualificationException {
        return "поехали";
    }

    public String stop() {
        return "останавливаемся";
    }

    public String turnRight() {
        return "поворот направо";
    }

    public String turnLeft() {
        return "поворот налево";
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }
}
