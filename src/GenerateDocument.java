import java.util.HashMap;

/*
You're given a string of available characters and a string representing a document that you need to generate. Write a function
that determines if you can generate the document using the available characters. You're only able to generate the document if the
frequency of unique characters in the characters string is greater than or equal to teh frequency of unique characters in the
document string.
 */
public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {
        // Frequency map of characters
        HashMap<Character, Integer> charsMap = new HashMap<>();
        // Frequency map of document
        HashMap<Character, Integer> docMap = new HashMap<>();

        // Frequency of characters must be >= those in docMap
        for (int i = 0; i < characters.length(); i++ ) {
            charsMap.merge(characters.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < document.length(); i++ ) {
            docMap.merge(document.charAt(i), 1, Integer::sum);
        }

        // Frequency of characters must be >= those in docMap
        for (Character i : docMap.keySet()) {
            if (charsMap.get(i) == null)
                return false;
            if (docMap.get(i) > charsMap.get(i))
                return false;
        }

        return true;
    }

}
