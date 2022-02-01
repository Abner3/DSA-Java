import java.util.HashMap;
import java.util.Map;

/*
Write a function that takes in a string of lowercase letters and returns the index of the string's first non-repeating character.
If the input string doesn't have any non-repeating characters, your function should return -1.
 */

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> occuranceMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            occuranceMap.merge(string.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < string.length(); i++) {
            if (occuranceMap.get(string.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
