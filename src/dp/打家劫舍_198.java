package dp;

public class 打家劫舍_198 {
    public static void main(String[] args) {

    }
    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        nums[1]=Math.max(nums[0], nums[1]);
        int res=nums[1];
        for (int i=2;i<nums.length;i++){
            nums[i]=Math.max(nums[i-2]+nums[i], nums[i-1]);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
