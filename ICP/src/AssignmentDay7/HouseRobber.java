package AssignmentDay7;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0, prev1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] houses1 = {1, 2, 3, 1};
        int[] houses2 = {2, 7, 9, 3, 1};

        System.out.println( rob(houses1)); // Expected: 4
        System.out.println( rob(houses2)); // Expected: 12
    }
}
