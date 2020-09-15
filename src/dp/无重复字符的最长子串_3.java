package dp;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int preLen = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0;i<s.length();i++){
            int lenSet = set.size();
            set.add(s.charAt(i));
            if (lenSet==set.size()){ //i处字符与前面有重复
                preLen=Math.min(lengthOfEndI(s, i), preLen+1);
            }
            else {
                preLen++;
            }
            maxLen=Math.max(maxLen, preLen);
        }
        return maxLen;
    }
    public static int lengthOfEndI(String s, int i){
        int j=i-1;
        char c=s.charAt(i);
        while (s.charAt(j)!=c){
            j--;
        }
        return i-j;
    }
}
