package Assignment_Day2;

import java.util.*;

public class KthLargestElementinanArray {
	//TC: O(n log n)
    // SC: O(n)
	public static void main(String[] args) {
		int[] nums1 = { 3, 2, 1, 5, 6, 4 };
		int k1 = 2;
		System.out.println(findKthLargest(nums1, k1)); // Expected: 5


		int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k2 = 4;
		System.out.println(findKthLargest(nums2, k2)); // Expected: 4
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int num : nums) {
			pq.add(num);
		}

		for (int i = 1; i < k; i++) {
			pq.poll();
		}

		return pq.peek();
	}
}