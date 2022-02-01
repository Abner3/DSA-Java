import java.util.Comparator;
import java.util.PriorityQueue;

/*
Write a function that takes in an array of at least three integers and without sorting the input array, returns a sorted
array of the three largest integers in the input array.
 */

public class ThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        PriorityQueue<Integer> maxTop3 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minOfMax = new PriorityQueue<>();

        for ( int i = 0; i < array.length; i++ ) {
            if (i < 3){
                maxTop3.add(array[i]);
                minOfMax.add(array[i]);
            }
            if(minOfMax.peek() < array[i]) {
                maxTop3.remove(minOfMax.remove());
                minOfMax.add(array[i]);
                maxTop3.add(array[i]);
            }
        }
        return new int[] { minOfMax.remove(), minOfMax.remove(), minOfMax.remove()};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {55, 7, 8};
        System.out.println(findThreeLargestNumbers(arr1));
    }
}
