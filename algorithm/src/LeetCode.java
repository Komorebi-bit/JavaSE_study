import java.nio.charset.StandardCharsets;

/**
 * @author Komorebi
 * @since 2022.10.29.16:36
 */
public class LeetCode {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "pwwkew";
        int len = solution.lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        byte[] bytes = s.getBytes();
        int len = bytes.length;

        return 0;
    }
}
