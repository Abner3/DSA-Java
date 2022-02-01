/*
Write a function that takes in a non-empty string and returns its run-length encoding (see Wikipedia for RLE)

 */
public class RunLengthEncoding {

    public String runLengthEncoding(String string) {
        int currLen = 0;
        char prev = string.charAt(0);
        StringBuilder sol = new StringBuilder();
        for ( int i = 0; i < string.length(); i++) {
            // continue the current run-length
            if (prev == string.charAt(i)) {
                currLen++;
                prev = string.charAt(i);
            }

            // found a new run-length
            else {
                // encode the currLen with prev char
                while(currLen > 9) {
                    sol.append(9);
                    sol.append(prev);
                    currLen -= 9;
                }
                sol.append(currLen);
                sol.append(prev);

                // reset prev char and currLen
                currLen = 1;
                prev = string.charAt(i);
            }
        }

        // flush out the currLen and prev after the for loop finishes
        while(currLen > 9) {
            sol.append(9);
            sol.append(prev);
            currLen -= 9;
        }
        sol.append(currLen);
        sol.append(prev);
        return sol.toString();
    }

}
