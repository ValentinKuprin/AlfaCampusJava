package ru.alfabank.campus.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private Person person;

    @BeforeEach
    void setPerson() {
        person = new Person(
                "Василий",
                "Иванов",
                1990);
    }

    @Test
    void should_GetName() {
        assertEquals("Василий", person.getName());
    }

    @Test
    void should_GetLastName() {
        assertEquals("Иванов", person.getLastName());
    }

    @Test
    void should_GetYearOfBirth() {
        assertEquals(1990, person.getYearOfBirth());
    }

    @Test
    void should_TestToString() {
        assertEquals("Фамилия: Иванов; Имя: Василий", person.toString());
    }
}