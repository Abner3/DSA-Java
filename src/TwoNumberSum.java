import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        List<Integer> targetSums = new ArrayList<>();
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = i1 + 1; i2 < array.length; i2++) {
                if (array[i1] + array[i2] == targetSum) {
                    targetSums.add(array[i1]);
                    targetSums.add(array[i2]);
                }
            }
        }
        Integer targetSumsInteger[] = new Integer[targetSums.size()];
        targetSums.toArray(targetSumsInteger);
        int[] targetSumsInt = Arrays.stream(targetSumsInteger).mapToInt(i -> i).toArray();
        return targetSumsInt;
    }

    public static void main(String[] args) {
        int[] test1Array = {1, 2, 4, 6};
        int test1Sum = 7;

        int[] test1Sol = twoNumberSum(test1Array, test1Sum);
        Arrays.stream(test1Sol).forEach(x -> System.out.print(x + " "));
        System.out.println(Arrays.toString(test1Sol));
    }
}
