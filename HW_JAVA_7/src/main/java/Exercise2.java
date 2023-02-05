import university.Student;

import java.util.List;

/* Требования:
1. Метод removeStudents должен модифицировать коллекцию List<Student> удаляя из нее студентов с gpa ниже переданного
и возвращать ее на выходе
 */

public class Exercise2 {
    public List<Student> removeStudents(List<Student> students, int gpa) {
        students.removeIf(s -> s.getGpa() < gpa);
        return students;
    }
}
