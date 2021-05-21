package leetcode.dfs;

import java.util.*;

public class 组合总和II_40 {
    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
        int a = 0;
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    public static void dfs(int[] nums, int target, List<Integer> temp, int index){
        if (target==0){
            List<Integer> tempCopy = new ArrayList<Integer>(Arrays.asList(new Integer[temp.size()]));
            Collections.copy(tempCopy, temp);
            res.add(tempCopy);
        }
        else if (target>0){
            for (int i=index;i<nums.length;i++){
                if (i>index&&nums[i-1]==nums[i]){
                    continue;
                }
                temp.add(nums[i]);
                dfs(nums,target-nums[i], temp, i+1);
                temp.remove(temp.size()-1);
            }
        }

    }
}
