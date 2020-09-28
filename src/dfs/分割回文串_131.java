package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/28
 */
public class 分割回文串_131 {
//    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//    返回 s 所有可能的分割方案。
//
//    示例:
//
//    输入: "aab"
//    输出:
//            [
//            ["aa","b"],
//            ["a","a","b"]
//            ]
    public static List<List<String>> partition(String s) {
        //dp[][]记录所有的回文子串
        int len = s.length();
        int[][] dp = new int[len][len];
        //斜着遍历矩阵右上角
        for (int i=0;i<len;i++){
            for (int j=0;j<len-i;j++){
                int k = i+j;
                if (j==k||((j==k-1||dp[j+1][k-1]==1)&&s.charAt(j)==s.charAt(k))) dp[j][k]=1;
            }
        }
        //dfs
        List<List<String>> res = new ArrayList<>();
        dfs(s,res,dp,new ArrayList<String>(),0);
        return res;
    }

    public static void dfs(String s,List<List<String>> res,int[][] dp,List<String> temp,int index){
        if (index==s.length()){
            List<String> tempCopy = Arrays.asList(new String[temp.size()]);
            Collections.copy(tempCopy, temp);
            res.add(tempCopy);
        }
        for (int i=index;i<s.length();i++){
            if (dp[index][i]==1){
                temp.add(s.substring(index,i+1));
                dfs(s,res,dp,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        partition("aabaa");
    }
}
