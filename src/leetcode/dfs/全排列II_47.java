package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 全排列II_47 {
    public static void main(String[] args) {
        List<List<Integer>> res = permuteUnique(new int[]{1,1,2});
        int a = 1;
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), res, new boolean[nums.length]);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited){
        for (int i=0;i<nums.length;i++){
            if (i>0&&nums[i-1]==nums[i]&&!visited[i-1]){
                continue;
            }
            if (!visited[i]){
                temp.add(nums[i]);
                visited[i]=true;
                dfs(nums, temp, res, visited);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
        if (temp.size()==nums.length){
            List<Integer> tempCopy = new ArrayList<Integer>(Arrays.asList(new Integer[temp.size()]));
            Collections.copy(tempCopy, temp);
            res.add(tempCopy);
        }
    }
}
