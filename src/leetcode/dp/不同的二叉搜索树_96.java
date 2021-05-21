package leetcode.dp;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/9
 */
public class 不同的二叉搜索树_96 {
//    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
//    示例:
//
//    输入: 3
//    输出: 5
//    解释:
//    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3

    public int numTrees(int n) {
        if(n==0){
            return 0;
        }
        //dp数组记录节点为n时的结果
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1;i<=n;i++){
            for (int a=0;a<i;a++){
                dp[i]+=dp[a]*dp[i-1-a];
            }
        }
        return dp[n];
    }
}
