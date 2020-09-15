package array;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组_560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res=0;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if (!map.containsKey(sum)){
                map.put(sum,1);
            }
            else {
                map.put(sum,map.get(sum)+1);
            }
            if (sum==k){
                res++;
            }
            if (k!=0&&map.containsKey(sum-k)){
                res=res+map.get(sum-k);
            }
            else if(k==0&&map.containsKey(sum-k)){
                res=res+map.get(sum-k)-1;      //将此次的除去
            }
        }
        return res;
    }
}
