package leetcode.dp;

public class 正则匹配_dp解法_10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }

    /**
     * '.'匹配任意单个字符,'*'匹配*前面字符0个或者多个
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for (int i=0;i<=sLen;i++){
            for (int j=1;j<=pLen;j++){
                if (p.charAt(j-1)=='*'){
                    //'*'匹配0个字符
                    if (dp[i][j-2]){
                        dp[i][j]=true;
                    }
                    //'*'匹配至少一个字符
                    if (i>0&&(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.')&&dp[i-1][j]){
                        dp[i][j]=true;
                    }
                }
                else {
                    if (i>0&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')&&dp[i-1][j-1]){
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
}
