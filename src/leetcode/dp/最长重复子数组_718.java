package leetcode.dp;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/14
 */
public class 最长重复子数组_718 {
//    给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//    示例：
//
//    输入：
//    A: [1,2,3,2,1]
//    B: [3,2,1,4,7]
//    输出：3
//    解释：
//    长度最长的公共子数组是 [3, 2, 1] 。
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (A[i]==B[j]){
                    if (i-1<0||j-1<0||dp[i-1][j-1]==0){
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
