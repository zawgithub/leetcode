package leetcode.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class 计算右侧小于当前元素的个数_315 {
    public static void main(String[] args) {
        countSmaller(new int[]{0,2,1});
    }

    /**
     * 思路:归并排序,降序排序nums的下标
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            res.add(0);
        }
        int[] indexs = new int[n];
        for (int i=0;i<n;i++){
            indexs[i]=i;
        }
        int[] temp = new int[n];
        merge(nums, res, indexs, temp, 0, n-1);
        return res;
    }

    public static void merge(int[] nums, List<Integer> res, int[] indexs, int[] temp, int left, int right){
        if (left==right){
            return;
        }
        int mid = (left+right)/2;
        merge(nums, res, indexs, temp, left, mid);
        merge(nums, res, indexs, temp,mid+1, right);
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=right){
            if (nums[indexs[i]]<=nums[indexs[j]]){
                temp[t++]=indexs[j++];
            }else {
                res.set(indexs[i], res.get(indexs[i])+(right-j+1));
                temp[t++]=indexs[i++];
            }
        }
        while (i<=mid){
            temp[t++]=indexs[i++];
        }
        while (j<=right){
            temp[t++]=indexs[j++];
        }
        for (int k=0;k<=t-1;k++){
            indexs[left+k]=temp[k];
        }
    }
}
