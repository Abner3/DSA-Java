import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
A tamdem bicycle is a bicycle that's operated by two people. Both people pedal the bicycle, but the person that pedals faster
dictates the speed of the bicycle. You're given two lists of positive integers that represent the speeds of the riders wearing
red shirts and riders wearing blue shirts. Both lists have the same length. Your goal is to pair every rider wearing a red shirt with
a rider wearing a blue shirt to operate a tandem bicycle. Write a function that returns the maximum possible total speed
or the minimum possible total speed based on the input parameter fastest.
 */

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int sol = 0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        // return maximum possible total speed
        if (fastest) {
            // pair fastest with slowest rider
            // reverse redShirtSpeeds
            List<Integer> redShirtSpeedsList = Arrays.stream(redShirtSpeeds).boxed().collect(Collectors.toList());
            redShirtSpeedsList.sort(Comparator.reverseOrder());
            redShirtSpeeds = redShirtSpeedsList.stream().mapToInt(i -> i).toArray();

            for (int i = 0; i < redShirtSpeeds.length; i++) {
                // red shirts are fastest
                // blue shirts are slowest
                sol += Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
            }
        }


        // return minimum total speed
        else {
            // pair fastest with fastest rider

            for (int i = 0; i < redShirtSpeeds.length; i++) {
                sol += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }

        return sol;

    }
}
