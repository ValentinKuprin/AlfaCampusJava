package university;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Person {
    String firstName;
    String middleName;
    String lastName;

    public Person() {
        firstName = getRandomFirstName();
        middleName = getRandomMiddleName();
        lastName = getRandomLastName();
    }

    private String getRandomFirstName() {
        List<String> firstNames = new ArrayList<>(Arrays.asList("Василий",
                "Пётр", "Никита", "Дмитрий", "Сергей", "Егор", "Илья",
                "Андрей", "Павел", "Николай", "Фёдор", "Даниил"));
        return firstNames.get(new Random().nextInt(firstNames.size()));
    }

    private String getRandomMiddleName() {
        List<String> middleNames = new ArrayList<>(Arrays.asList("Васильевич",
                "Петрович", "Дмитриевич", "Даниилович", "Николаевич", "Эдуардович",
                "Сергеевич", "Иванович", "Евгениевич", "Артемович", "Александрович", "Алексеевич"));
        return middleNames.get(new Random().nextInt(middleNames.size()));
    }

    private String getRandomLastName() {
        List<String> lastNames = new ArrayList<>(Arrays.asList("Иванов",
                "Петров", "Сидоров", "Кузнецов", "Попов", "Васильев",
                "Соколов", "Лазарев", "Медведев", "Ершов", "Громов", "Карпов"));
        return lastNames.get(new Random().nextInt(lastNames.size()));
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }
}
