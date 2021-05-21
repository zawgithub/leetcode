package leetcode.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级_241 {
    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("2*3-4*5");
        int a = 1;
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        boolean isNum = true;
        for (int i=0;i<input.length();i++){
            if (input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
                isNum = false;
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (int l=0;l<left.size();l++){
                    for (int r=0;r<right.size();r++){
                        if (input.charAt(i)=='+'){
                            res.add(left.get(l)+right.get(r));
                        }
                        else if (input.charAt(i)=='-'){
                            res.add(left.get(l)-right.get(r));
                        }
                        else {
                            res.add(left.get(l)*right.get(r));
                        }
                    }
                }
            }
        }
        if (isNum){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
