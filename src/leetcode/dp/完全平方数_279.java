package leetcode.dp;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/14
 */
public class 完全平方数_279 {
//    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//    示例 1:
//
//    输入: n = 12
//    输出: 3
//    解释: 12 = 4 + 4 + 4.
//    示例 2:
//
//    输入: n = 13
//    输出: 2
//    解释: 13 = 4 + 9.

    public int numSquares(int n) {
        int a = 1;
        int[] dp = new int[n+1];
        while (a*a<=n){
            dp[a*a]=1;
            a++;
        }
        for (int i=1;i<=n;i++){
            if (dp[i]==0){
                dp[i]=i;
                for (int j=1;j*j<i;j++){
                    dp[i]=Math.min(dp[i], dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
}
