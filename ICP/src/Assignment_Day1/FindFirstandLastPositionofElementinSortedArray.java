import java.util.*;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums1 = {5,7,7,8,8,10};
        int target1 = 8;
        System.out.println(Arrays.toString(searchRange(nums1, target1))); // [3,4]

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        System.out.println(Arrays.toString(searchRange(nums2, target2))); // [-1,-1]

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true);
        if(result[0] == -1) return result;  // target not found
        result[1] = findBound(nums, target, false);
        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                bound = mid;
                if(isFirst) right = mid - 1;
                else left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
