package Labs2;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        int result = name.compareTo(other.getName());

        if (result != 0) {
            return result;
        }

        return Integer.compare(age, other.getAge());
    }
}