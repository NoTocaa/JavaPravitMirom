package Labs3;

import java.math.BigInteger;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        BigInteger divisor = BigInteger.ONE;
        BigInteger[] output = new BigInteger[nums.size()];

        for (int pass = 0; pass < 20; pass++) {
            int[] count = new int[10];


            for (int i = 0; i < nums.size(); i++) {
                BigInteger number = nums.get(i);

                int digit = number.divide(divisor)
                        .remainder(BigInteger.TEN)
                        .intValue();

                count[digit]++;
            }


            for (int digit = 1; digit < count.length; digit++) {
                count[digit] += count[digit - 1];
            }


            for (int i = nums.size() - 1; i >= 0; i--) {
                BigInteger number = nums.get(i);

                int digit = number.divide(divisor)
                        .remainder(BigInteger.TEN)
                        .intValue();

                output[count[digit] - 1] = number;
                count[digit]--;
            }


            for (int i = 0; i < nums.size(); i++) {
                nums.set(i, output[i]);
            }


            divisor = divisor.multiply(BigInteger.TEN);
        }
    }
}