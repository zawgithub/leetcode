package leetcode.quicksort;

import java.util.PriorityQueue;
import java.util.Queue;

public class 数组中的第k个最大元素_215 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest_2(nums, 4));
    }
    //快排解法
    public static int findKthLargest_1(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length-1);
    }
    public static int quickSort(int[] nums, int k, int left, int right){
        int i=left+1,j=right;
        int flag=left;
        while (i<=j){
            while (i<=j&&nums[j]<=nums[flag]){
                j--;
            }
            if (i<=j&&nums[j]>nums[flag]){
                swap(nums,flag,j);
                flag=j;
                j--;
            }
            while (i<=j&&nums[i]>nums[flag]){
                i++;
            }
            if (i<=j&&nums[i]<=nums[flag]){
                swap(nums,flag,i);
                flag=i;
                i++;
            }

        }
        if (flag+1==k){
            return nums[flag];
        }
        else if (flag+1<k){
            return quickSort(nums, k, flag+1, right);
        }
        else {
            return quickSort(nums, k, left, flag-1);
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //堆实现
    public static int findKthLargest_2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i=0;i<k;i++){
            queue.offer(nums[i]);
        }
        for (int i=k;i<nums.length;i++){
            if (queue.peek()<nums[i]){
                queue.offer(nums[i]);
                queue.poll();
            }
        }
        return queue.peek();
    }
}
