package dfs;

import java.util.*;

public class 组合之和_39 {
    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5}, 8);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                temp.add(nums[i]);
                dfs(nums,target-nums[i], temp, i);
                temp.remove(temp.size()-1);
            }
        }

    }
}
