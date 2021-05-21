package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/21
 */
public class 组合之和III_216 {
//    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//    说明：
//
//    所有数字都是正整数。
//    解集不能包含重复的组合。 
//    示例 1:
//
//    输入: k = 3, n = 7
//    输出: [[1,2,4]]
//    示例 2:
//
//    输入: k = 3, n = 9
//    输出: [[1,2,6], [1,3,5], [2,3,4]]
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), k, n, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int k, int n, int i) {
        if (temp.size()==k) {
            if (n==0) {
                List<Integer> tempCopy = new ArrayList<>(Arrays.asList(new Integer[k]));
                Collections.copy(tempCopy, temp);
                res.add(tempCopy);
            }
            return;
        }
        for (int j=i;j<=9;j++) {
            temp.add(j);
            dfs(res, temp, k, n-j, j+1);
            temp.remove(temp.size()-1);
        }
    }

}
