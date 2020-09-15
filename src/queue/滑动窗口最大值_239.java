package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口最大值_239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        int a = 1;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0||k==0){
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0;i<k;i++){
            if (deque.isEmpty()||nums[deque.peekLast()]>nums[i]){
                deque.offerLast(i);
            }
            else {
                while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
        }
        res[0]=nums[deque.peekFirst()];
        for (int i=k;i<nums.length;i++){
            if (deque.isEmpty()||nums[deque.peekLast()]>nums[i]){
                deque.offerLast(i);
            }
            else {
                while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            if (i-k==deque.peekFirst()){
                deque.pollFirst();
            }
            res[i-k+1]=nums[deque.peekFirst()];
        }

        return res;
    }
}
