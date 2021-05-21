package leetcode.dp;

import java.util.List;

/**
 * @Author: zhaoanwei
 * @Date: 2020/10/16
 */
public class 单词拆分_139 {
//    给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//    说明：
//
//    拆分时可以重复使用字典中的单词。
//    你可以假设字典中没有重复的单词。
//    示例 1：
//
//    输入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//    示例 2：
//
//    输入: s = "applepenapple", wordDict = ["apple", "pen"]
//    输出: true
//    解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//                 注意你可以重复使用字典中的单词。
//    示例 3：
//
//    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//    输出: false
    public boolean wordBreak(String s, List<String> wordDict) {
        //leetcode.dp[i]表示, s[:i]是否能被拆分
        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i=0;i<len;i++){
            for (String word : wordDict){
                int length = word.length();
                if (i+1>=length&&word.equals(s.substring(i+1-length,i+1))&&(i+1==length||dp[i-length])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
