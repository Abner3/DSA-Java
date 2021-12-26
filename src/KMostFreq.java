import java.util.*;

public class KMostFreq {

    /*
    Given a non-empty array of integers, return up to k most frequent elements, in the order of frequency desc.
    For example,
    Given [4,4,4,5,5,6] and k = 2, return [4,5].
     */
    public static class tuple implements Comparable<tuple> {
        public int val, occurrence;

        public tuple(int val, int occurrence) {
            this.val = val;
            this.occurrence = occurrence;
        }

        @Override
        public int compareTo(tuple other) {
            return Integer.compare(this.occurrence, other.occurrence);
        }
    }

    public static Integer[] topK(Integer[] arr, int k) {
        PriorityQueue<tuple> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> sol = new ArrayList<>();

        // populate the hash map
        for (int i : arr) {
//            map.merge(i, 1, Integer::sum);
            map.merge(i, 1, Integer::sum);
        }

        // populate the priority queue
        for (Integer key : map.keySet()) {
            maxPQ.add(new tuple(key, map.get(key)));
        }

        while (k != 0) {
            sol.add(maxPQ.remove().val);
            k--;
        }
        return sol.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        Integer[] test1 = new Integer[]{4, 4, 4, 5, 5, 6};
        int k1 = 2;
        System.out.println(Arrays.toString(topK(test1, k1))); // return [4,5]
    }

}
