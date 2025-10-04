package Assignment_Day5;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(sol.eraseOverlapIntervals(intervals)); // output  1
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int cnt = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                cnt++; 
            } else {
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
