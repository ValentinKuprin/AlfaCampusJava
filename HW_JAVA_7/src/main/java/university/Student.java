package university;

public class Student {
    Person person;
    char group;
    int course;
    int gpa;

    public Student(Person person) {
        this.person = person;
    }

    public Student(Person person, char group, int course, int gpa) {
        this.person = person;
        this.group = group;
        this.course = course;
        this.gpa = gpa;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public char getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public int getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", group=" + group +
                ", course=" + course +
                ", gpa=" + gpa +
                '}';
    }
}
