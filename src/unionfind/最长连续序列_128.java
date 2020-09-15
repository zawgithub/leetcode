package unionfind;

import java.util.HashMap;
import java.util.Map;

public class 最长连续序列_128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    /**
     * 要求时间为O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res=0;
        for (int num:nums){
            if (map.containsKey(num)){
                continue;
            }
            int left = map.containsKey(num-1)?map.get(num-1):0;
            int right = map.containsKey(num+1)?map.get(num+1):0;
            int len = left+right+1;
            res = Math.max(res, len);
            map.put(num, 1);  //随便赋值,标记num在map中已存在
            map.put(num-left, len);  //左边端点
            map.put(num+right, len); //右边端点
        }
        return res;
    }
}
