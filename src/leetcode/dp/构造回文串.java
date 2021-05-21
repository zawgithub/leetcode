package leetcode.dp;

import java.util.Scanner;

public class 构造回文串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            System.out.println(s.length()-maxHuiwen(s));
        }

        sc.close();
    }

    /**
     * s中最大非连续回文串的长度
     * @param s
     * @return
     */
    public static int maxHuiwen(String s){
        int res=1;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int k=0;k<len;k++){
            for (int i=0;i<len-k;i++){
                int j=i+k;
                if(i==j){
                    dp[i][j]=1;
                }
                else if(i==j-1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }
                    else{
                        dp[i][j]=1;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=Math.max(Math.max(dp[i][j-1], dp[i+1][j]), dp[i+1][j-1]+2);
                    }
                    else {
                        dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
                res=Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}
