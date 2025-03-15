import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Komorebi
 * @since 2022.10.11.17:33
 */
public class App13 {

    public static void main(String[] args) {
        String s = "leetcodecode";
        int len = s.length();
        //当dp[i]=true时，表示字符串从下标0到i可以成功划分
        boolean[] dp = new boolean[s.length()];
        List<String> wordDict = Arrays.asList("me", "leetco","leet", "co", "code");
        split(s, wordDict, dp,0);
        System.out.println(dp[len-1]);
    }

    public static void split(String s, List<String> wordDict, boolean[] dp,int start) {
        int len = s.length();
        if(start == len){
            return;
        }
        for (int i = start; i < len; i++) {
            for (int j=i+1; j <= len; j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    dp[j-1] = true;
                    split(s,wordDict,dp,j);
                    if(dp[len-1]){
                        return;
                    }
                }
            }
        }

    }
}
