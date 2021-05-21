package leetcode.doubleindex;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/1
 */
public class 至少有K个重复字符的最长子串_395 {
//    给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
//    示例 1：
//
//    输入：s = "aaabb", k = 3
//    输出：3
//    解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//    示例 2：
//
//    输入：s = "ababbc", k = 2
//    输出：5
//    解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
//             
//    提示：
//            1 <= s.length <= 10^4
//            s 仅由小写英文字母组成
//            1 <= k <= 10^5

    //思路：枚举滑动窗口里的字符种类:1-26, 分别求出这26种情况的解, 其中最大值即为结果
    public int longestSubstring(String s, int k) {
        int len = s.length();
        int ret = 0;
        for (int t=1;t<=26;t++){
            int l=0,r=0;
            //charNum记录每个字符在滑动窗口中的个数
            int[] charNum = new int[26];
            //窗口内的字符种类数
            int total = 0;
            //窗口内个数少于k的字符种类数
            int less = 0;
            //窗口内字符种类为t时的结果
            int max = 0;
            while (r<len) {
                charNum[s.charAt(r)-'a']++;
                //判断窗口内的字符种类
                if (charNum[s.charAt(r)-'a']==1) {
                    total++;
                    less++;
                }
                if (charNum[s.charAt(r)-'a']==k) less--;
                //当total>t时,右移l
                while (total>t) {
                    l++;
                    charNum[s.charAt(l-1)-'a']--;
                    if (charNum[s.charAt(l-1)-'a']==0) {
                        total--;
                        less--;
                    }
                    if (charNum[s.charAt(l-1)-'a']==k-1) less++;
                }
                //当total=t、less=0时，计算当前结果
                if (total==t&&less==0) max = Math.max(max, r-l+1);
                r++;
            }
            ret = Math.max(ret, max);
        }
        return ret;
    }

}
