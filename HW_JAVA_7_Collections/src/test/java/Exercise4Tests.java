import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import university.Student;

import java.util.HashMap;
import java.util.Map;

public class Exercise4Tests {
    Exercise4 exercise4 = new Exercise4();
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Test
    void checkGenerateMapOfStudents() {
        Map<Integer, Student> studentsMap = exercise4.generateMapOfStudents(5);
        Assertions.assertEquals(5, studentsMap.keySet().size());
    }

    @Test
    void checkGetStudentsKeys() {
        studentsMap = exercise4.generateMapOfStudents(5);
        Assertions.assertEquals(5, exercise4.getStudentsKeys(studentsMap).size());
        for (int i = 0; i < 5; i++) {
            Assertions.assertTrue(studentsMap.containsKey(i));
        }
    }

    @Test
    void checkGetStudentValues() {
        studentsMap = exercise4.generateMapOfStudents(5);
        Assertions.assertEquals(5, exercise4.getStudentValues(studentsMap).size());
    }

    @Test
    void checkRemoveStudent() {
        studentsMap = exercise4.generateMapOfStudents(5);
        String removableStudentName = studentsMap.get(0).getPerson().toString();
        exercise4.removeStudent(studentsMap, removableStudentName);
        Assertions.assertFalse(studentsMap.containsKey(0));
    }

    @Test
    void checkRenameStudent() {
        studentsMap = exercise4.generateMapOfStudents(5);
        System.out.println(studentsMap);
        String renamableStudentName = studentsMap.get(0).getPerson().toString();
        exercise4.renameStudent(studentsMap, renamableStudentName);
    }
}
