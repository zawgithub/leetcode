package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/7
 */
public class 俄罗斯套娃信封问题_354 {
//    给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//    当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//    请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//    注意：不允许旋转信封。
//             
//    示例 1：
//    输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//    输出：3
//    解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
//
//    示例 2：
//    输入：envelopes = [[1,1],[1,1],[1,1]]
//    输出：1
//             
//    提示：
//    1 <= envelopes.length <= 5000
//    envelopes[i].length == 2
//    1 <= wi, hi <= 10^4

    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len==0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int res = 1;
        int[] dp = new int[len];
        for (int i=0;i<len;i++) dp[i]=1;
        for (int i=1;i<len;i++) {
            for (int j=0;j<i;j++) {
                if (envelopes[j][0]<envelopes[i][0]
                        &&envelopes[j][1]<envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;


    }

}
