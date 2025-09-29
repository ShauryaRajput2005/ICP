package Assignment_Day3;

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Solution sol = new Solution();
		System.out.println(sol.spiralOrder(matrix)); // [1,2,3,6,9,8,7,4,5]
	}

	static class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			int minr = 0, minc = 0;
			int maxr = matrix.length - 1;
			int maxc = matrix[0].length - 1;

			List<Integer> result = new ArrayList<>();
			int total = matrix.length * matrix[0].length;

			while (result.size() < total) {
				for (int i = minc; i <= maxc && result.size() < total; i++) {
					result.add(matrix[minr][i]);
				}
				minr++;

				for (int i = minr; i <= maxr && result.size() < total; i++) {
					result.add(matrix[i][maxc]);
				}
				maxc--;

				for (int i = maxc; i >= minc && result.size() < total; i--) {
					result.add(matrix[maxr][i]);
				}
				maxr--;

				for (int i = maxr; i >= minr && result.size() < total; i--) {
					result.add(matrix[i][minc]);
				}
				minc++;
			}
			return result;
		}
	}

}
