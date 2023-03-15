package ru.alfabank.campus.animal;

public class Cat extends Pet{

    public void cathcMouse() {
        System.out.println("Поймала мышку");
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}
