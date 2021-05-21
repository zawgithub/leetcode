package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/25
 */
public class 组合_77 {
//    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//    示例:
//
//    输入: n = 4, k = 2
//    输出:
//            [
//            [2,4],
//            [3,4],
//            [2,3],
//            [1,2],
//            [1,3],
//            [1,4],
//            ]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,k,res,new ArrayList<Integer>(),1);
        return res;
    }

    public void dfs(int n,int k,List<List<Integer>> res,List<Integer> temp,int index){
        if (temp.size()==k){
            List<Integer> tempCopy = Arrays.asList(new Integer[k]);
            Collections.copy(tempCopy,temp);
            res.add(tempCopy);
        }
        if (index<=n){
            for (int i=index;i<=n;i++){
                temp.add(i);
                dfs(n,k,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
