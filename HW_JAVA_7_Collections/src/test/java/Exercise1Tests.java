import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import university.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1Tests {
    private static List<Student> students;

    @BeforeAll
    static void setStudentsList() {
        Exercise1 exercise1 = new Exercise1();
        students = exercise1.generateStudents(100);
    }

    @Test
    void checkStudentsQuantity() {
        Assertions.assertEquals(100, students.size(), "Размер списка не совпадает с переданным значением");
    }

    @Test
    void checkGroupValues() {
        List<Character> groups = new ArrayList<Character> (Arrays.asList('A', 'B', 'C'));
        for (Student student:students) {
            Assertions.assertTrue(groups.contains(student.getGroup()), "Такой \"" + student.getGroup() +"\" группы быть не должно, группы A, B, C");
        }
    }

    @Test
    void checkCourseValues() {
        for (Student student:students) {
            Assertions.assertTrue(student.getCourse() <= 5 && student.getCourse() >=0, "Курс студента не входит в диапазон от 0 до 5");
        }
    }

    @Test
    void checkGpaValues() {
        for (Student student:students) {
            Assertions.assertTrue(student.getGpa() <= 100 && student.getGpa() >= 0, "Средний балл не входит в диапазон от 0 до 100");
        }
    }
}
