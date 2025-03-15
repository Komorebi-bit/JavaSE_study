import java.util.Arrays;
import java.util.List;

/**
 * @author Komorebi
 * @since 2022.10.16.16:07
 */
public class App14 {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"me","leetco","leet","co","code"};
        boolean bool = split(s, wordDict,0);
        System.out.println(bool);
    }

    public static boolean split(String s, String[] wordDict,int i) {
        int len = s.length();
        int n = wordDict.length;
        if(i<len){
            int j=0;
            while(j<n){
                int k = i, l = wordDict[j].length();
                while(k<len && k < i+l && s.charAt(k) == wordDict[j].charAt(k-i)){
                    k++;
                }
                if(k == len){
                    return true;
                }
                if(k == i+l){
                    if(split(s, wordDict, k)){
                        return true;
                    }
                }
                j++;
            }
        }
        return false;
    }
}
