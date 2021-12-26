import java.util.ArrayList;
import java.util.Comparator;

/*
Half the students will be wearing blue or red shirts. There are two rows, one for the red shirts and another for the blue shirts.
All students in the back row should be strictly taller than the student directly in front of them.
Write a function that returns whether or not a class photo that follows these guidelines can be taken.
 */

public class ClassPhoto {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Comparator.naturalOrder());
        blueShirtHeights.sort(Comparator.naturalOrder());
        // can the x-shirts be front row?
        boolean blueShirtFront = true, redShirtFront = true;

        for (int i = 0; i < blueShirtHeights.size(); i++) {
            // check if blueShirts cannot be in front
            if (redShirtHeights.get(i) <= blueShirtHeights.get(i))
                blueShirtFront = false;
            // check if redShirts cannot be in front
            if (redShirtHeights.get(i) >= blueShirtHeights.get(i))
                redShirtFront = false;
        }
        return blueShirtFront || redShirtFront;
    }

}
