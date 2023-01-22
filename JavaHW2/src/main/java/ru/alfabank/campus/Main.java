package ru.alfabank.campus;

import ru.alfabank.campus.animal.Cat;
import ru.alfabank.campus.animal.Dog;
import ru.alfabank.campus.animal.Hamster;
import ru.alfabank.campus.person.Person;
import ru.alfabank.campus.phone.Phone;

public class Main {
    private static void line() {
        System.out.println("_____________________________________________________");
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        line();

        Person person = new Person("Василий", "Иванов", 1990);
        Person owner = new Person("Игорь", "Андреев", 1988);

        System.out.println(person);
        System.out.println(owner);
        line();

        Phone phone = new Phone();
        Phone modelPhone = new Phone("iphone13");
        Phone modelPhoneNumber = new Phone("NothingPhone", "+79168122022");
        Phone allParameters = new Phone("Samsung22", "+79991234666", owner);
        System.out.println(phone);
        System.out.println(modelPhone);
        System.out.println(modelPhoneNumber);
        System.out.println(allParameters);
        line();

        Cat cat = new Cat();
        cat.cathcMouse();
        cat.makeSound();
        cat.sleep();
        cat.play();
        System.out.println("У кошки " + cat.getPawsCount() + " лапки");
        line();

        Dog dog = new Dog();
        dog.bringStick();
        dog.makeSound();
        dog.sleep();
        dog.play();
        System.out.println("У собаки " + dog.getPawsCount() + " лапки");
        line();

        Hamster hamster = new Hamster();
        hamster.hideFood();
        hamster.makeSound();
        hamster.sleep();
        hamster.play();
        System.out.println("У хомяка " + hamster.getPawsCount() + " лапки");
        line();
    }
}