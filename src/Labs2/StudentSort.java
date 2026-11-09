package Labs2;

import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {

        for (int i = 0; i < students.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(j).getAge()
                        < students.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }

            Student temp = students.get(i);
            students.set(i, students.get(minIndex));
            students.set(minIndex, temp);
        }

        for (int i = 1; i < students.size(); i++) {
            Student key = students.get(i);
            int j = i - 1;

            while (j >= 0
                    && students.get(j).getName()
                    .compareTo(key.getName()) > 0) {

                students.set(j + 1, students.get(j));
                j--;
            }

            students.set(j + 1, key);
        }
    }
}