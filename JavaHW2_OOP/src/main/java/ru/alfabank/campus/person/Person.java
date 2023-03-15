package ru.alfabank.campus.person;

/*
Задания которые необходимо выполнить в данном классе
1. В пакете *person* в классе **Person** задать поля: имя, фамилия и год рождения. Добавить конструктор для всех полей класса.
        Добавить геттеры.
3. Переопределить метод *toString()* в классе **Person** чтобы на выходе получить вывод строки в формате:
        *Фамилия: Петров; Имя: Петр*. Написать программу, которая создает два объекта класса **Person** и выводит на экран фамилию
        и имя
 */

public class Person {
    private final String name;
    private final String lastName;
    private final int yearOfBirth;

    public Person(String name, String lastName, int yearOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {

        return "Фамилия: " + lastName +
                "; Имя: " + name;
    }
}
