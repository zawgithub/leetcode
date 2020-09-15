package dp;

public class 编辑距离_72 {
    public static void main(String[] args) {
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

    /**
     * 将word1编辑成word2的最少次数
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<m+1;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(j-1)==word2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                }
            }
        }
        return dp[n][m];
    }
}
