import java.util.*;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int cur, int start) {
        if (cur == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (cur > target) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; 
            temp.add(nums[i]);
            backtrack(result, temp, nums, target, cur + nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println("Example 1:");
        System.out.println(combinationSum2(candidates1, target1));

        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println("Example 2:");
        System.out.println(combinationSum2(candidates2, target2));
    }
}
