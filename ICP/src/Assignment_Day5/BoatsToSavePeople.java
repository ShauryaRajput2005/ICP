package Assignment_Day5;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = {3,5,3,4};
        int limit = 5;
        System.out.println(sol.numRescueBoats(people, limit)); // expected 4
    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boat = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boat++;
        }
        return boat;
    }
}
