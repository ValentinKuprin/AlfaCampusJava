package ru.alfabank.campus.animal;


public class Hamster extends Pet{
    public void hideFood() {
        System.out.println("Вся еда моя");
    }

    @Override
    public void makeSound() {
        System.out.println("Ш-ш-ш");
    }
}
