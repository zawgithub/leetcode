package leetcode.dp;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/8
 */
public class 分割字符串_132 {
//    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
//    返回符合要求的 最少分割次数 。
//
//    示例 1：
//    输入：s = "aab"
//    输出：1
//    解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//
//    示例 2：
//    输入：s = "a"
//    输出：0
//
//    示例 3：
//    输入：s = "ab"
//    输出：1
//             
//    提示：
//    1 <= s.length <= 2000
//    s 仅由小写英文字母组成
    public static int minCut(String s) {
        int len = s.length();
        int[][] dp1 = new int[len][len];
        //斜着遍历矩阵右上角
        for (int k=0;k<len;k++) {
            for (int i=0;i<len-k;i++) {
                int j = i+k;
                if (k==0) dp1[i][j]=1;
                else if (k==1) {
                    if (s.charAt(i)==s.charAt(j)) dp1[i][j]=1;
                }else {
                    if (s.charAt(i)==s.charAt(j)&&dp1[i+1][j-1]==1) dp1[i][j]=1;
                }
            }
        }

        int[] dp2 = new int[len];
        dp2[0] = 0;
        for (int i=1;i<len;i++) {
            dp2[i] = len;
            if (dp1[0][i]==1) dp2[i] = 0;
            for (int j=0;j<i;j++) {
                if (dp1[j+1][i]==1) dp2[i] = Math.min(dp2[i], dp2[j]+1);
            }
        }

        return dp2[len-1];
    }

    public static void main(String[] args) {
        int minCut = minCut("aab");
    }
}
