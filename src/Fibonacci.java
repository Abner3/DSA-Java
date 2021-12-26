import java.util.List;
import java.util.stream.Stream;

/*
Calculate the n'th fibonacci number
 */

public class Fibonacci {
    public static void main(String[] args) {
        List<Integer> sol = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]}).limit(5).map(i -> i[0]).toList();
        System.out.println(sol.get(sol.size() - 1));
    }
}
