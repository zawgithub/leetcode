package leetcode.array;

/**
 * @Author: zhaoanwei
 * @Date: 2020/10/15
 */
public class 分割数组_915 {
//    给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
//
//    left 中的每个元素都小于或等于 right 中的每个元素。
//    left 和 right 都是非空的。
//    left 要尽可能小。
//    在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
//
//    示例 1：
//
//    输入：[5,0,3,8,6]
//    输出：3
//    解释：left = [5,0,3]，right = [8,6]
//    示例 2：
//
//    输入：[1,1,1,0,6,12]
//    输出：4
//    解释：left = [1,1,1,0]，right = [6,12]

//    2 <= A.length <= 30000
//            0 <= A[i] <= 10^6
//    可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
    public int partitionDisjoint(int[] A) {
        //从右向左遍历, 计算出A[i:]的最小值, 并用数组dp[i]存储
        int n = A.length;
        int[] dp = new int[n];
        dp[n-1] = A[n-1];
        for (int i = n-2;i >= 0;i--) dp[i] = Math.min(dp[i+1], A[i]);
        //max存储A[:i]最大值
        int max = A[0];
        for (int i = 0;i < n-1;i++){
            if (max <= dp[i+1]) return i+1;
            max = Math.max(max, A[i+1]);
        }
        return 0;
    }
}
