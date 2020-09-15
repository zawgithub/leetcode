package dp;

public class 买卖股票的最佳时机III_123 {
    public static void main(String[] args) {
        买卖股票的最佳时机III_123 leetcode = new 买卖股票的最佳时机III_123();
        int[] prices = new int[8];
        prices[0]=3;
        prices[1]=3;
        prices[2]=5;
        prices[3]=0;
        prices[4]=0;
        prices[5]=3;
        prices[6]=1;
        prices[7]=4;
        System.out.println(leetcode.maxProfit(prices));

    }
    public int maxProfit(int[] prices) {
        int res=0;
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int[] dp1 = new int[len];
        int minNum = Integer.MAX_VALUE;
        for (int i=1;i<len;i++){
            if(prices[i-1]<minNum){
                minNum=prices[i-1];
            }
            int temp=prices[i]-minNum;
            if(res<temp){
                res=temp;
            }
            dp1[i]=res;
        }
        if(len>=3){
            int minMin=prices[1]-dp1[0];
            for(int i=1;i<len-1;i++){
                if (minMin>prices[i]-dp1[i-1]){
                    minMin=prices[i]-dp1[i-1];
                }
                if (res<prices[i+1]-minMin){
                    res=prices[i+1]-minMin;

                }
            }
        }
        if(res<0){
            return 0;
        }
        return res;
    }
}
