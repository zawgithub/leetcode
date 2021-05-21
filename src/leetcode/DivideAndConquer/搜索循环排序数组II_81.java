package leetcode.DivideAndConquer;

public class 搜索循环排序数组II_81 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            while (left<right&&nums[left]==nums[left+1]){
                left++;
            }
            while (left<right&&nums[right]==nums[right-1]){
                right--;
            }
            mid = (left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //左边有序
            if(nums[mid]>=nums[left]){
                //在有序那边
                if(target<=nums[mid]&&target>=nums[left]){
                    right = mid-1;
                }
                //在无序那边
                else{
                    left = mid+1;
                }
            }
            //右边有序
            else{
                //在有序那边
                if(target>=nums[mid]&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
