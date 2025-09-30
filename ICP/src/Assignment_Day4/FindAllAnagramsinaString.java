package Assignment_Day4;

import java.util.*;

public class FindAllAnagramsinaString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : p.toCharArray()) {
            freq1[ch - 'a']++;
        }

        int win = p.length();
        for (int i = 0; i < s.length(); i++) {
            freq2[s.charAt(i) - 'a']++;

            if (i >= win) {
                freq2[s.charAt(i - win) - 'a']--;
            }

            if (Arrays.equals(freq1, freq2)) {
                result.add(i - win + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p)); // [0, 6]
    }
}
