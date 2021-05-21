package leetcode.quicksort;

public class 颜色分类_75 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(arr);
    }
    public static void sortColors(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<j){
            while (i<j&&nums[i]==0){
                i++;
            }
            while (i<j&&nums[j]!=0){
                j--;
            }
            swap(nums, i, j);

        }
        int p=i;
        int q=nums.length-1;
        while (p<q){
            while (p<q&&nums[p]==1){
                p++;
            }
            while (p<q&&nums[q]==2){
                q--;
            }
            swap(nums, p, q);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
