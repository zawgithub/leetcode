package dp;

public class 零钱兑换_322 {
    public static void main(String[] args) {
        int[] coins = new int[3];
        coins[0]=2;
        coins[1]=3;
        coins[2]=5;
        System.out.println(coinChange(coins, 11));
    }
    /**
     * 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        for (int i=1;i<=amount;i++){
            int temp=Integer.MAX_VALUE;
            for (int k=0;k<coins.length;k++){
                if (i-coins[k]>=0){
                    temp=Math.min(temp, dp[i-coins[k]]);
                }
            }
            dp[i]=temp==Integer.MAX_VALUE?temp:temp+1;
        }
        return dp[amount]=dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
