package stack;

import java.util.Stack;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/8
 */
public class 最大矩形_85 {

//    给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//    示例:
//
//    输入:
//            [
//            ["1","0","1","0","0"],
//            ["1","0","1","1","1"],
//            ["1","1","1","1","1"],
//            ["1","0","0","1","0"]
//            ]
//    输出: 6

    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //第0层柱状图, 默认都是0
        int[] height = new int[n];
        //动态规划计算每一层的柱状图
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]=='1'){
                    height[j]++;
                }else {
                    height[j]=0;
                }
            }

            max = Math.max(max, func(height));
        }
        return max;
    }

    /**
     * 求一个柱状图的最大矩形的面积
     * @param heights
     * @return
     */
    public int func(int[] heights){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0;i<heights.length;i++){
            while (stack.peek()!=-1&&heights[stack.peek()]>=heights[i]){
                int pop = stack.pop();
                max = Math.max(max, (heights[pop])*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            int pop = stack.pop();
            max = Math.max(max, (heights[pop])*(heights.length-stack.peek()-1));
        }
        return max;
    }
}
