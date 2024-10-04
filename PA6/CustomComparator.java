import java.util.Comparator;

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String arg1, String arg2) {
        return arg1.compareTo(arg2);
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.grade == o2.grade)
            return o1.name.compareTo(o2.name);
        return o1.grade - o2.grade;
    }
}