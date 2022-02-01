/*
Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns
a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k is the key.
 */
public class CaesarCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder sol = new StringBuilder();
//        for (Character i : str)
        for (int j = 0; j < str.length(); j++) {
            char i = str.charAt(j);
            while ((int)i + key > 122) {
                i = (char) ((int) i - 26);
            }
            i = (char) ((int) i + key);

            sol.append(i);
        }
        return sol.toString();
    }

    public static void main(String[] args) {
        String test1 = "xyz";
        int key1 = 2;

        System.out.println(caesarCypherEncryptor(test1, key1));
    }

}
