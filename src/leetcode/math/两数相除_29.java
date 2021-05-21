package leetcode.math;

public class 两数相除_29 {

//    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//    返回被除数 dividend 除以除数 divisor 得到的商。
//
//    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

    public int divide(int dividend, int divisor) {
        //判定边界
        if (dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }

        if (dividend==Integer.MIN_VALUE&&divisor==Integer.MIN_VALUE){
            return 1;
        }
        if(divisor==Integer.MIN_VALUE){
            return 0;
        }
        boolean isMin = false;
        if (dividend==Integer.MIN_VALUE){
            dividend += Math.abs(divisor);
            isMin = true;
        }

        //判断dividend和divisor是否同号
        boolean b = (dividend > 0) ^ (divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int res = 0;
        for (int i=31;i>=0;i--){
            if ((dividend>>1)>=divisor){
                res += 1<<i;
                dividend -= divisor<<i;
            }
        }
        if (isMin) res++;
        return b?-res:res;
    }
}
