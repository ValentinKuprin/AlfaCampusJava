import university.Person;
import university.Student;

import java.util.*;

/* Требования:
1. Метод generateMapOfStudents должен вернуть Map в которой Integer - порядковый номер студента, Student - студент
2. Метод getStudentsKeys должен возвращать только ключи из переданной Map
3. Метод getStudentValues должен возвращать список <Student> из переданной на вход Map
4. Метод removeStudent должен удалять из карты пару ключ-значение студента ФИО которого содержит переданную строку
5. Метод renameStudent должен переименовывать всех студентов фио которых содержит переданную строку

Подсказка:
Для манипуляции над объектом не обязательно его возвращать, можно провести манипуляцию над тем кто передан на вход
 */


public class Exercise4 {
    public Map<Integer, Student> generateMapOfStudents(int quantity) {
        Map<Integer, Student> studentsMap = new HashMap<>();

        if (quantity > 0) {
            for (int i = 0; i < quantity; i++) {
                studentsMap.put(i, new Student(new Person()));
            }
            return studentsMap;
        }
        return studentsMap;
    }

    public List<Integer> getStudentsKeys(Map<Integer, Student> studentMap) {
        return new ArrayList<>(studentMap.keySet());
    }

    public List<Student> getStudentValues(Map<Integer, Student> studentMap) {
        return new ArrayList<>(studentMap.values());

    }

    public void removeStudent(Map<Integer, Student> studentsMap, String value) {
        studentsMap.values().removeIf(student -> student.toString().contains(value));
    }

    public void renameStudent(Map<Integer, Student> studentsMap, String value) {
        for (Map.Entry<Integer, Student> student : studentsMap.entrySet()) {
            if (student.getValue().toString().contains(value)) {
                student.getValue().getPerson().setNewPersonName();
            }
        }
    }
}
