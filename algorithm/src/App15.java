import java.util.Arrays;
import java.util.List;

/**
 * @author Komorebi
 * @since 2022.10.16.21:11
 */
public class App15 {

    public static void main(String[] args) {
        String s = "leetcodecode";
        int len = s.length();
        List<String> wordDict = Arrays.asList("me", "leetco", "leet", "co", "code");
        boolean result = wordDivide(s, wordDict);
        System.out.println(result);
    }

    public static boolean wordDivide(String s, List<String> wordDict) {
        int len = s.length();
        //当dp[i]，表示字符串从下标0到i是否可以成功划分
        boolean[] dp = new boolean[len + 1];
        // 空串能被拆分
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }

}
