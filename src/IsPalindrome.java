/*
Check whether a string is a palindrome or not
 */

public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length()-1; i < j; i++, j-- ) {
            // if they don't match
            if ( str.charAt(i) != str.charAt(j) )
                return false;
        }
        return true;
    }

}
