package leetcode.doubleindex;

public class 乘积小于k的子数组_713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int res=0;
        int product=nums[0];
        while (j<nums.length){
            while (i<j&&product>=k){
                product=product/nums[i];
                i++;
            }
            if (product>=k){
                i++;
                j++;
                if (j<nums.length){
                    product=nums[j];
                }

            }
            else {
                res=res+j-i+1;
                j++;
                if (j<nums.length){
                    product=product*nums[j];
                }
            }
        }
        return res;
    }
}
