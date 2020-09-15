package array;

public class 求众数_169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public static int majorityElement(int[] nums) {
        int res=nums[0];
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==res){
                count++;
            }
            else if (count==0){
                count=1;
                res=nums[i];

            }
            else {
                count--;
            }
        }
        return res;
    }
}
