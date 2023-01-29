package professions;

/* Требования:
1. Класс должен содержать следующие поля
String fio
int drivingExpirience
int mileage
double mileageInYear, считается как mileage деленный на drivingExpirience, если деление выбрасывает ошибку, то присваиваем этому полю значение переменной mileage
Поля должны быть приватными
2. В классе должен быть конструктор, который инициализирует все поля класса

PS: При необходимости получить доступ к приватным полям класса использовать геттеры/сеттеры
 */

public class Driver {
    private final String fio;
    private final int drivingExpirience;
    private final int mileage;
    private double mileageInYear;

    public Driver(String fio, int drivingExpirience, int mileage) {
        this.fio = fio;
        this.drivingExpirience = drivingExpirience;
        this.mileage = mileage;
        try {
            this.mileageInYear = mileage / drivingExpirience;
        } catch (ArithmeticException e) {
            this.mileageInYear = mileage;
        }
    }

    public String getFio() {
        return fio;
    }

    public int getDrivingExpirience() {
        return drivingExpirience;
    }

    public double getMileageInYear() {
        return mileageInYear;
    }
}
