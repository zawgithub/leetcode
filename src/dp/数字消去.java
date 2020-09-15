package dp;

import java.util.Scanner;

public class 数字消去 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(numSplit(n, k));
    }

    /**
     * 手中的初始数为n,可以将手中的数分裂(分裂次数<=k),也可以全部-1,求将手中数消去的最少次数
     * @param n
     * @param k
     * @return
     */
    public static int numSplit(int n, int k){
        int[][] dp = new int[n+1][k+1];
        for (int i=1;i<=n;i++){
            for (int j=0;j<=k;j++){
                if (i==1){
                    dp[i][j]=1;
                }
                else if (j==0){
                    dp[i][j]=i;
                }
                else {
                    int mid = 0;
                    if (i%2==0){
                        mid = i/2;
                    }
                    else {
                        mid = i/2+1;
                    }
                    dp[i][j]=Math.min(dp[i-1][j], dp[mid][j-1])+1;
                }
            }
        }
        return dp[n][k];
    }
}
