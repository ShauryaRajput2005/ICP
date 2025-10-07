package Assignment_Day7;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {1};
        int[] test3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(test1)); // Expected: 6
        System.out.println(maxSubArray(test2)); // Expected: 1
        System.out.println(maxSubArray(test3)); // Expected: 23
    }
}
