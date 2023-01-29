package details;

/* Требования:
1. Класс должен содержать следующие поля
int power
String manufacturer
Поля должны быть приватными
2. В классе должен быть конструктор который инициализирует все поля класса

PS: При необходимости получить доступ к приватным полям класса использовать геттеры/сеттеры
 */

public class Engine {
    private final int power;
    private final String manufacturer;

    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    public int getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
