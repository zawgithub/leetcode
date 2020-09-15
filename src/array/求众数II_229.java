package array;

import java.util.ArrayList;
import java.util.List;

public class 求众数II_229 {
    public static void main(String[] args) {
        List<Integer> res = majorityElement(new int[]{1,1,1,3,3,2,2,2});
        System.out.println();
    }

    /**
     * 超过n/3的数
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        int num1 = nums[0];
        int num2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==num1){
                count1++;
            }
            else if (nums[i]==num2){
                count2++;
            }
            else if (count1==0){
                count1=1;
                num1=nums[i];
            }
            else if (count2==0){
                count2=1;
                num2=nums[i];
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num:nums){
            if (num==num1){
                count1++;
            }
        }
        if (count1>nums.length/3){
            res.add(num1);
        }

        for (int num:nums){
            if (num==num2){
                count2++;
            }
        }
        if (count2>nums.length/3){
            res.add(num2);
        }
        if (num1==num2){
            res.remove(1);
        }
        return res;
    }
}
