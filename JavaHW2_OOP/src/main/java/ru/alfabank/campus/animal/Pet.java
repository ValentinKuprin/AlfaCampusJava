package ru.alfabank.campus.animal;

public abstract class Pet {
    private static final int PAWS_COUNT = 4;

    public void sleep() {
        System.out.println("я сплю");
    }

    public void play() {
        System.out.println("я играю");
    }

    public abstract void makeSound();

    public int getPawsCount() {
        return PAWS_COUNT;
    }
}
