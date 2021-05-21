package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhaoanwei
 * @Date: 2020/11/27
 */
public class 最大间距_164 {
//    给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
//    如果数组元素个数小于 2，则返回 0。
//
//    示例 1:
//
//    输入: [3,6,9,1]
//    输出: 3
//    解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
//    示例 2:
//
//    输入: [10]
//    输出: 0
//    解释: 数组元素个数小于 2，因此返回 0。
//    说明:
//
//    你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
//    请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
public int maximumGap(int[] nums) {
    if (nums.length == 0||nums.length == 1){
        return 0;
    }
    int n = nums.length;
    int min = nums[0];
    int max = nums[0];
    for (int i=0;i<n;i++){
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
    }
    if(max == min){
        return 0;
    }
    List<List<Integer>> buckets = bucketSort(nums, max, min);
    if(buckets == null){
        return 0;
    }
    int maxGap = 0;
    for (int i=0;i<buckets.size()-1;i++){
        maxGap = Math.max(maxGap, buckets.get(i+1).get(0)-buckets.get(i).get(1));
    }
    return maxGap;
}

    //桶排序, 每个桶仅存储最大值和最小值
    private List<List<Integer>> bucketSort(int[] nums, int max, int min){
        if (nums == null){
            return null;
        }
        int n = nums.length;
        int bucketSize = (int)Math.ceil((double)(max-min)/(n-1));
        int bucketNum = (int)Math.ceil((double)(max-min)/bucketSize + 1);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i=0;i<bucketNum;i++){
            buckets.add(new ArrayList<Integer>());
        }
        for(int num:nums){
            int i = (num - min) / bucketSize;
            if (buckets.get(i).size()==0){
                buckets.get(i).add(num);
                buckets.get(i).add(num);
            }else {
                if (num<buckets.get(i).get(0)){
                    buckets.get(i).set(0, num);
                }
                else if(num>buckets.get(i).get(1)){
                    buckets.get(i).set(1, num);
                }
            }
        }
        //去除空桶
        List<List<Integer>> newBuckets = new ArrayList<>();
        for (List<Integer> list:buckets){
            if (list.size()!=0){
                newBuckets.add(list);
            }
        }
        return newBuckets;
    }

}
