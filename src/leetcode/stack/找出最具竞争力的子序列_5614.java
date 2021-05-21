package leetcode.stack;

import java.util.Stack;

/**
 * @Author: zhaoanwei
 * @Date: 2020/11/29
 */
public class 找出最具竞争力的子序列_5614 {
//    给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
//
//    数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
//
//    在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
//    示例 1：
//
//    输入：nums = [3,5,2,6], k = 2
//    输出：[2,6]
//    解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
//    示例 2：
//
//    输入：nums = [2,4,3,3,5,4,9,6], k = 4
//    输出：[2,3,3,4]
//             
//
//    提示：
//
//            1 <= nums.length <= 10^5
//            0 <= nums[i] <= 10^9
//            1 <= k <= nums.length

    //思路：单调栈
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        //边界判断
        if (n == 0||n < k){
            return null;
        }
        if (n == k){
            return nums;
        }
        //准备一个长度为k的栈
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++){
            if (stack.isEmpty()){
                stack.push(nums[i]);
                continue;
            }
            if (nums[i]>=stack.peek()){
                if (stack.size()<k){
                    stack.push(nums[i]);
                }
                continue;
                //leetcode.stack.size() == k时,不做处理，跳过
            }
            if (nums[i]<stack.peek()){
                int m = n-i-(k-stack.size());
                for (int j=0;j<m;j++){
                    if (stack.isEmpty()||nums[i]>=stack.peek()){
                        break;
                    }
                    if (nums[i]<stack.peek()){
                        stack.pop();
                    }
                }
                stack.push(nums[i]);
            }

        }
        int[] res = new int[k];
        for (int i=k-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }

}
