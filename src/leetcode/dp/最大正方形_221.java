package leetcode.dp;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/8
 */
public class 最大正方形_221 {
//    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
//    示例:
//
//    输入:
//
//            1 0 1 0 0
//            1 0 1 1 1
//            1 1 1 1 1
//            1 0 0 1 0
//
//    输出: 4
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        //dp二维数组存储正方形的最大边长, <i,j>为正方形的右下角坐标
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
