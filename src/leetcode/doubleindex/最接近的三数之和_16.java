package leetcode.doubleindex;

import java.util.Arrays;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/29
 */
public class 最接近的三数之和_16 {
//    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//    示例：
//
//    输入：nums = [-1,2,1,-4], target = 1
//    输出：2
//    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0]+nums[1]+nums[2];
        int min = Math.abs(target-closestNum);
        for (int i=0;i<nums.length-2;i++){
            //l、r两个指针分别从左、右检测
            int l=i+1,r=nums.length-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int dist = Math.abs(target-sum);
                //若三数之和等于target, 则直接返回
                if (dist==0) return sum;
                if (dist<min){
                    min = dist;
                    closestNum = sum;
                }
                if (sum < target){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return closestNum;
    }
}
