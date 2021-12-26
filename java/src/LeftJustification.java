import java.io.*;
import java.util.*;

public class LeftJustification {
    // If you need extra classes, you can define them privately here within class Solution

    // Prints to standard out.
    static void reflowLines(int lineLength, List<String> lines) {
        int currentLineLength = 0;

        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line);
            boolean flagDeleteFirstDash = true;

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                //System.out.println("\nDEBUG: word = " + word);
                // if the word can't fit, put the word on a new line
                if (currentLineLength + word.length() + 1 > lineLength) {
                    while (currentLineLength <= lineLength) {
                        System.out.print('-');
                        currentLineLength++;
                    }
                    currentLineLength = word.length();
                    System.out.print("\n" + word);
                    //System.out.print("#");
                } else if (currentLineLength + word.length() + 1 <= lineLength) {
                    currentLineLength += word.length() + 1;
                    if (flagDeleteFirstDash) {
                        System.out.print(word);
                        flagDeleteFirstDash = false;
                    } else if (!flagDeleteFirstDash)
                        System.out.print("-" + word);
                }
            }
        }
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        int arg0 = -1;
        List<String> arg1 = new ArrayList<>();

        String line;
        boolean first_arg = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                if(first_arg) {
                    arg0 = Integer.parseInt(line);
                    first_arg = false;
                } else {
                    arg1.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        reflowLines(arg0, arg1);
    }
}
