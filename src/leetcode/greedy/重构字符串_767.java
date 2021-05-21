package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zhaoanwei
 * @Date: 2020/11/30
 */
public class 重构字符串_767 {
//    给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//    若可行，输出任意可行的结果。若不可行，返回空字符串。
//
//    示例 1:
//
//    输入: S = "aab"
//    输出: "aba"
//    示例 2:
//
//    输入: S = "aaab"
//    输出: ""
//    注意:
//
//    S 只包含小写字母并且长度在[1, 500]区间内。

    private static class CharNum{
        char c;
        int num;
        CharNum(char c, int num){
            this.c = c;
            this.num = num;
        }
    }
    public static String reorganizeString(String S) {
        //边界判断
        if (S.length() == 0||S.length() == 1){
            return S;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxNum = 0;
        for (int i=0;i<S.length();i++){
            if (!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), 1);
                maxNum = Math.max(maxNum, 1);
                continue;
            }
            map.put(S.charAt(i), map.get(S.charAt(i))+1);
            maxNum = Math.max(maxNum, map.get(S.charAt(i)));
        }
        if (maxNum > (S.length()+1)/2){
            return "";
        }
        PriorityQueue<CharNum> maxHeap = new PriorityQueue<>((o1, o2) -> o2.num - o1.num);
        for (char c:map.keySet()){
            maxHeap.offer(new CharNum(c, map.get(c)));
        }
        StringBuilder res = new StringBuilder();
        while (maxHeap.size()>=2){
            CharNum charNum1 = maxHeap.poll();
            CharNum charNum2 = maxHeap.poll();
            res.append(charNum1.c);
            res.append(charNum2.c);
            charNum1.num = charNum1.num-1;
            charNum2.num = charNum2.num-1;
            if (charNum1.num != 0){
                maxHeap.offer(charNum1);
            }
            if (charNum2.num != 0){
                maxHeap.offer(charNum2);
            }
        }
        if (maxHeap.size() == 1){
            res.append(maxHeap.poll().c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String aaabbc = reorganizeString("aaabbc");
    }
}
