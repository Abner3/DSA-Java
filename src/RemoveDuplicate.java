import java.util.HashMap;

public class RemoveDuplicate {

    public static char[] removeDuplicate(char[] arr) {
        HashMap<Character, Integer> occurenceMap = new HashMap<>();
        int numOfConflicts = 0;
        for (int i = 0, trueI = 0; i < arr.length; i++, trueI++) {
            Character curr = arr[i];
            // once I have traversed the array, trim any meaningless off the end of the arr
            if (trueI == arr.length-1 && trueI != i) {
                for (; i < trueI; i++){
                    arr[i] = '\0';
                }
                break;
            }
            // first occurrence
            if (occurenceMap.get(curr) == null) {
                occurenceMap.put(curr, 1);
                continue;
            }

            // character has appeared already
            int occurrenceNum = occurenceMap.get(curr);

            // if odd occurrence, then overwrite character
            if (occurrenceNum % 2 == 1) {
                if (i < arr.length-2) {
                    shift(arr, i);
                    i--;
                }
                // if the character is the last, no need to shift. Just delete it
                else if (i == arr.length-1) {
                    arr[i] = '\0';
                }
                numOfConflicts++;
            }
            occurenceMap.put(curr, occurrenceNum++);
        }

        return arr;
    }

    public static void shift(char[] arr, int iParam) {
        for (int i = iParam; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
    }

    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'a'};
        char[] test2 = {'a', 'b', 'b', 'a', 'c'};
        char[] test3 = {'a', 'b', 'a', 'a'};
        char[] test1Result = removeDuplicate(test3);
        System.out.println(test1Result);
    }
}
