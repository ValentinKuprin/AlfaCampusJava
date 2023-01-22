package ru.alfabank.campus.phone;

import ru.alfabank.campus.person.Person;

/*
Задания которые необходимо выполнить в данном классе
2. В пакете *phone* в классе **Phone** задать поля: модель, номер телефона, владелец - должен быть типа Person. Добавить
конструкторы: пустой, принимающий только модель, принимающий модель и номер телефона, принимающий все поля.
4. Написать программу, которая создает 4 объекта класса **Phone** (из всех конструкторов) и выводит каждый объект на экран
5. В классе **Phone** добавить методы: - получения модели телефона - изменения и получения номера телефона - вывода
полной информации о телефоне в строке формата: "Владелец телефона: Вася Иванов. Модель: iphone13. Номер телефона: +79267737272"
 */
public class Phone {
    private String model;
    private String phoneNumber;
    private Person owner;

    public Phone() {
    }

    public Phone(String model) {
        this.model = model;
    }

    public Phone(String model, String phoneNumber) {
        this.model = model;
        this.phoneNumber = phoneNumber;
    }

    public Phone(String model, String phoneNumber, Person owner) {
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        if (owner != null && model != null && phoneNumber != null) {

            return "Владелец телефона: " + owner.getName() + " " + owner.getLastName() +
                    ". Модель: " + model +
                    ". Номер телефона: " + phoneNumber;
        } else if (owner == null && model != null && phoneNumber != null) {

            return "Модель: " + model +
                    ". Номер телефона: " + phoneNumber;
        } else if (owner == null && phoneNumber == null && model != null) {

            return "Модель: " + model + ".";
        } else {

            return "Данные отсутствуют";
        }
    }
}
