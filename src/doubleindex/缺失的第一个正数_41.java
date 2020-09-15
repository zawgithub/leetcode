package doubleindex;

public class 缺失的第一个正数_41 {
    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<=right){
            if (nums[left]==left+1){
                left++;
            }
            else if (nums[left]>0&&nums[left]<=right+1&&nums[left]!=nums[nums[left]-1]){
                swap(nums, left, nums[left]-1);
            }
            else {
                nums[left]=nums[right];
                right--;
            }
        }
        return left+1;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
