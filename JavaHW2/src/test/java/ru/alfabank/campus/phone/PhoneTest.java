package ru.alfabank.campus.phone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.alfabank.campus.person.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneTest {

    private Phone empty;
    private Phone withModel;
    private Phone withPhoneNumber;
    private Phone all;
    private Person person;

    @BeforeEach
    void setUp() {
        empty = new Phone();
        withModel = new Phone("айфон");
        withPhoneNumber = new Phone("айфон", "+79277738727");
        person = new Person("Василий", "Иванов", 1990);
        all = new Phone("iphone13", "+79267737272", person);
    }

    @Test
    void should_GetModel() {
        assertEquals("айфон", withModel.getModel());
    }

    @Test
    void should_GetPhoneNumber() {
        assertEquals("+79277738727", withPhoneNumber.getPhoneNumber());
    }

    @Test
    void should_SetPhoneNumber() {
        String newPhoneNumber = "79993337722";
        empty.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, empty.getPhoneNumber());
    }

    @Test
    void should_TestToString() {
        assertEquals("Владелец телефона: Василий Иванов. Модель: iphone13. Номер телефона: +79267737272",
                all.toString());
    }

}