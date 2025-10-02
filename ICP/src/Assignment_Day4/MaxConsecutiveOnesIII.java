package Assignment_Day4;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeros = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();

        // Test case 1
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.longestOnes(nums1, k1));
        // Expected: 6

        // Test case 2
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        System.out.println("Test Case 2: " + solution.longestOnes(nums2, k2));
        // Expected: 10

        // Test case 3
        int[] nums3 = {1,1,1,1,1};
        int k3 = 0;
        System.out.println("Test Case 3: " + solution.longestOnes(nums3, k3));
        // Expected: 5

        // Test case 4
        int[] nums4 = {0,0,0,0};
        int k4 = 2;
        System.out.println("Test Case 4: " + solution.longestOnes(nums4, k4));
        // Expected: 2
    }
}
