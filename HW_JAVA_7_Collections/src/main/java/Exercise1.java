/* Требования:
1. Метод generateStudents должен возвращать коллекцию List<Student> размера quantity
2. group в Student должны быть A,B,C
3. course от 0 до 5
4. gpa от 0 до 100

Подсказка:
1. Использовать random (https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
2. Для групп можно воспользоваться методом charAt (https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int))
 */

import university.Person;
import university.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1 {
    public List<Student> generateStudents(int quantity) {
        List<Student> studentsList = new ArrayList<>();

        if (quantity > 0) {
            String alphabet = "ABC";
            Random random = new Random();

            for (int i = 0; i < quantity; i++) {
                char group = alphabet.charAt(random.nextInt(alphabet.length()));
                int course = random.nextInt(5 + 1) ;
                int gpa = random.nextInt(100 + 1);

                studentsList.add(new Student(new Person(), group, course, gpa));
            }
            return studentsList;
        }
        return studentsList;
    }
}
