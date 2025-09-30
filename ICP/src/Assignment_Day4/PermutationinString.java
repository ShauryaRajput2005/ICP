package Assignment_Day4;

import java.util.Arrays;

public class PermutationinString {

    public static boolean checkInclusion(String s1, String s2) {
        int[] fre1 = new int[26];
        int[] fre2 = new int[26];

        for (char ch : s1.toCharArray()) {
            fre1[ch - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            fre2[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                fre2[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(fre1, fre2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2)); // true
    }
}
