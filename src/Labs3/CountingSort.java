package Labs3;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] count = new int[128];

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i);
            count[value]++;
        }

        int position = 0;

        for (int value = 0; value < count.length; value++) {
            for (int repeat = 0; repeat < count[value]; repeat++) {
                nums.set(position, value);
                position++;
            }
        }
    }
}