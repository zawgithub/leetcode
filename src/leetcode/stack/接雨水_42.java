package leetcode.stack;

import java.util.Stack;

public class 接雨水_42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,1,0,2}));
    }
    public static int trap(int[] height) {
        int res=0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<height.length;i++){
            if (stack.empty()||height[stack.peek()]>height[i]){
                stack.push(i);
            }
            else {
                while (!stack.empty()&&height[stack.peek()]<=height[i]){
                    int index = stack.peek();
                    stack.pop();
                    if (!stack.empty()) {
                        res = res + (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[index]);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
