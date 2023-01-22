package ru.alfabank.campus.animal;

public class Dog extends Pet{

    public void bringStick() {
        System.out.println("Я принес палку");
    }

    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}
