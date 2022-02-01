/*
Write a function that takes in a sorted array of integers as well as a target integer. Implement binarySearch.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int target) {

        for ( int leftPtr = 0, rightPtr = array.length-1; leftPtr <= rightPtr; ) {
            int middlePtr = (rightPtr + leftPtr) / 2;
            // If answer is closer to left partitition
            if ( array[middlePtr] > target ) {
                rightPtr = middlePtr-1;
            }

            // If answer is closer to right partitition
            else if ( array[middlePtr] < target ) {
                leftPtr = middlePtr+1;
            }

            // If answer is at middlePtr, return
            else if ( array[middlePtr] == target ) {
                return middlePtr;
            }
        }
        return -1;
    }

}
