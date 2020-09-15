package dp;

public class 打家劫舍II_213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length-1];
        int res=Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
            res=Math.max(res, dp[i]);
        }
        res=Math.max(res, nums[2]);
        nums[2]=Math.max(nums[1], nums[2]);
        for (int i=3;i<nums.length;i++){
            nums[i]=Math.max(nums[i-2]+nums[i], nums[i-1]);
            res=Math.max(res, nums[i]);
        }

        return res;
    }
}
