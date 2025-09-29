package Assignment_Day3;

import java.util.*;

public class Search2DMatrix {

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            if (n == 1 && m == 1 && target == matrix[0][0]) return true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
                    return check(matrix, target, i);
                }
            }
            return false;
        }

        public static boolean check(int[][] matrix, int target, int row) {
            int left = 0;
            int right = matrix[row].length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;

        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(matrix, target)); // true
    }
}
