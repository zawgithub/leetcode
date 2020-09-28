package array;

import java.util.Arrays;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/25
 */
public class 下一个排列_31 {
//    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//    必须原地修改，只允许使用额外常数空间。
//
//    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//            1,2,3 → 1,3,2
//            3,2,1 → 1,2,3
//            1,1,5 → 1,5,1
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        //边界处理
        if (len==0||len==1) return;
        //从后往前检查, 找出最短逆序序列
        int i = len-1;
        for (;i>0;i--){
            if (nums[i]>nums[i-1]) break;
        }
        if (i==0){
            Arrays.sort(nums);
            return;
        }
        //从后向前找到第一个比nums[i-1]大的数
        int j=len-1;
        for (;j>=i;j--){
            if (nums[j]>nums[i-1]) break;
        }
        //交换i-1和j的位置
        int temp = nums[j];
        nums[j] = nums[i-1];
        nums[i-1] = temp;
        Arrays.sort(nums, i, len);
    }
}
