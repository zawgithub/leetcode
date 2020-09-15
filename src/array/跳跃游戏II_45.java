package array;

public class 跳跃游戏II_45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    public static int jump(int[] nums) {
        int res=0;
        int start=0;
        int end=0;
        while (end<nums.length-1){
            int maxStep=end+1;
            for (int i=start;i<=end;i++){
                maxStep=Math.max(maxStep, i+nums[i]);
            }
            start=end+1;
            end=maxStep;
            res++;
        }
        return res;
    }
}
