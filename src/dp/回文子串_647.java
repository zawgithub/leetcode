package dp;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/6
 */
public class 回文子串_647 {

//    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

//    示例 1：
//    输入："abc"
//    输出：3
//    解释：三个回文子串: "a", "b", "c"

//    示例 2：
//    输入："aaa"
//    输出：6
//    解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

    public static int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int count = 0;
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (i==j){
                    count++;
                    if (i-1>=0&&j+1<=len-1&&s.charAt(i-1)==s.charAt(j+1)){
                        count++;
                        dp[i-1][j+1]=1;
                    }
                }else if (i==j-1&&s.charAt(i)==s.charAt(j)){
                    count++;
                    if (i-1>=0&&j+1<=len-1&&s.charAt(i-1)==s.charAt(j+1)){
                        count++;
                        dp[i-1][j+1]=1;
                    }
                }else if (dp[i][j]==1&&i-1>=0&&j+1<=len-1&&s.charAt(i-1)==s.charAt(j+1)){
                    count++;
                    dp[i-1][j+1]=1;
                }
            }
        }
        return count;
    }

    public static int countSubstrings1(String s) {
        if (s.length()==0){
            return 0;
        }
        //在字符串s的字符间插入#
        StringBuilder str = new StringBuilder();
        str.append("#");
        for (int i=0;i<s.length();i++){
            str.append(s.charAt(i)+"#");
        }
        int len = str.length();
        int count = 0;
        int[][] dp = new int[len][len];
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                if (i==j){
                    count++;
                    dp[i][j]=1;
                }else if (i!=j-1){
                    if (dp[i+1][j-1]==1&&str.charAt(i)==str.charAt(j)){
                        count++;
                        dp[i][j]=1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countSubstrings("aaaaa");
    }
}
