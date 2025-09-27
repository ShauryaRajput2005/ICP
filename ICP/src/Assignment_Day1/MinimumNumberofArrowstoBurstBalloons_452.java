package Assignment_Day1;
import java.util.*;

public class MinimumNumberofArrowstoBurstBalloons_452 {
	
//	Time Complexity: O(n log n) 
//	Space Complexity: O(1) 
	
    public static void main(String[] args) {
        int[][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points1)); // 2

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points2)); // 4

        int[][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points3)); // 2
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        long pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pos) {
                arrows++;
                pos = points[i][1];
            }
        }
        return arrows;
    }
}
