package array;

public class 跳跃游戏_55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
    //从后往前找,每个点找到前一个能到该点的点,因为如果连前一个点都不能到达，那么这个点也无法到达
    public static boolean canJump(int[] nums) {
        int nowIndex = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nowIndex-i<=nums[i]){
                nowIndex=i;
            }
        }
        if(nowIndex==0){
            return true;
        }
        else{
            return false;
        }
    }
}
