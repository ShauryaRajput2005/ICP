package Assignment_Day5;

import java.util.*;

public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = sol.reconstructQueue(people);
        for (int[] p : res) {
            System.out.println(Arrays.toString(p));
        }
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}
