package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utilities to work with digits of a number.
 * 
 */
public final class DigitUtils {

    public static long fromDigits(List<Integer> digits) {
        long result = 0;
        for (long d : digits) {
            result = result * 10 + d;
        }
        return result;
    }

    public static List<Integer> toDigits(long val) {
        List<Integer> result = new ArrayList<>();
        while (val > 0) {
            int d = (int) (val % 10);
            result.add(d);
            val /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
