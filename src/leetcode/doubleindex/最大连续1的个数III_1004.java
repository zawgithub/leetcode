package leetcode.doubleindex;

/**
 * @Author: zhaoanwei
 * @Date: 2021/2/20
 */
public class 最大连续1的个数III_1004 {
//    给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
//    返回仅包含 1 的最长（连续）子数组的长度。
//
//    示例 1：
//
//    输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//    输出：6
//    解释：
//            [1,1,1,0,0,1,1,1,1,1,1]
//    粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//    示例 2：
//
//    输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//    输出：10
//    解释：
//            [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//    粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//             
//    提示：
//
//            1 <= A.length <= 20000
//            0 <= K <= A.length
//    A[i] 为 0 或 1

    //思路：滑动窗口, l、r为窗口的左右端, r逐步后移,当[l,r]中的0大于K时,右移l
    public static int longestOnes(int[] A, int K) {
        int len = A.length;
        //l,r为窗口左右端位置, max为窗口大小, count记录窗口中0的个数
        int l=0,max=0,count=0;
        for (int r=0;r<len;r++){
            if (A[r]==0) count+=1;
            if (count>K) {
                while (l<len-1 && A[l]==1) l++;
                l+=1;
                count-=1;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0);
    }
}
