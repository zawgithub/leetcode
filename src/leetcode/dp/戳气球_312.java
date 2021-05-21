package leetcode.dp;

public class 戳气球_312 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
    public static int maxCoins(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int n = nums.length+2;
        int[] newNums = new int[n];
        newNums[0]=1;
        newNums[n-1]=1;
        for (int i=1;i<n-1;i++){
            newNums[i]=nums[i-1];
        }

        int[][] dp = new int[n][n];
        for(int k=1;k<n;k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i+k;
                if (j-i==1){
                    dp[i][j]=0;
                }
                else {
                    for (int mid=i+1;mid<j;mid++){
                        dp[i][j] = Math.max(dp[i][j], newNums[i]*newNums[mid]*newNums[j]+dp[i][mid]+dp[mid][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
