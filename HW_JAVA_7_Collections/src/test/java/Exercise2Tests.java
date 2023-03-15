import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import university.Person;
import university.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise2Tests {
    private static final List<Student> students = new ArrayList<>();

    @BeforeAll
    static void setStudentsList() {
        Random random = new Random();
        String chars = "ABC";
        for (int i = 0; i < 50; i++) {
            students.add(new Student(new Person(), chars.charAt(random.nextInt(chars.length())), random.nextInt(5), random.nextInt(100)));
        }
    }

    @Test
    void checkIsStudentsGPAHigherThanValue() {
        Exercise2 exercise2 = new Exercise2();
        List<Student> newStudentsList = exercise2.removeStudents(students, 75);
        for (Student student:newStudentsList) {
            Assertions.assertTrue(student.getGpa() >= 75, "В списке есть студенты у которых средний балл меньше переданного числа");
        }
    }
}
