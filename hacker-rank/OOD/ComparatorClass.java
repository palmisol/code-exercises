package OOD;

import java.util.Comparator;

class Student {
    int id;
    String name;
    String surname;
}

public class ComparatorClass implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.id - o2.id;
    }
}
