package leetcode.stack;

import java.util.Stack;

public class 直方图下最大矩形_84 {
    public static void main(String[] args) {
        int[] heights = new int[]{1};
        System.out.println(largestRectangleArea(heights));
    }
    /**
     * 直方图下最大矩形
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i=0;i<heights.length;i++){
            if (stack.peek()==-1){
                stack.push(i);
            }
            else if (heights[stack.peek()]<=heights[i]){
                stack.push(i);
            }
            else {
                while (stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
                    int index = stack.pop();
                    res = Math.max(heights[index]*(i-stack.peek()-1), res);
                }
                stack.push(i);
            }
        }
        int topIndex=0;
        if (stack.peek()!=-1){
            topIndex=stack.peek();
        }
        while (stack.peek()!=-1){
            int index = stack.pop();
            res = Math.max(heights[index]*(topIndex-stack.peek()), res);
        }
        return res;
    }
}
