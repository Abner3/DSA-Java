import java.util.Arrays;

/*
Given a non-empty array of positive integers representing the amounts of time that specific queries take to execute and
one query can be executed at a time, write a function that returns the minimum amount of total waiting time for all of
the queries.
 */

public class MinWaitTime {
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sol = 0, incrementalTotal = 0;
        for (int i = 0; i < queries.length; i++) {
            sol += incrementalTotal;
            incrementalTotal += queries[i];
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 4};
        minimumWaitingTime(test1);
        Integer[] test2 = Arrays.stream(test1).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(test2));
    }
}
