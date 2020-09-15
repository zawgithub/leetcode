package doubleindex;

public class 删除排序数组中的重复项II_80 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
    public static int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int count=1;
        while (j<nums.length){
            j++;
            if (j==nums.length){
                if (count>2){
                    i--;
                }
                break;
            }
            if (count<=2){
                i++;
            }
            if (nums[j]==nums[j-1]){
                count++;
            }
            else {
                count=1;
            }
            if (i!=j){
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
