package Assignment_Day6;

import java.util.*;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 1, k, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> ans, int n, int idx, int k, int cnt) {
        if (cnt == k) {
            result.add(new ArrayList<>(ans));
            return;
        }
        if (idx > n) return;

        // include
        ans.add(idx);
        backtrack(result, ans, n, idx + 1, k, cnt + 1);
        ans.remove(ans.size() - 1);

        // exclude 
        backtrack(result, ans, n, idx + 1, k, cnt);
    }

    public static void main(String[] args) {
        System.out.println("n=4, k=2: " + combine(4, 2));
        System.out.println("n=5, k=3: " + combine(5, 3));
    }
}
