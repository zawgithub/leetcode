package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 区间最大重合次数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)-> o1[0]-o2[0]);
        for(int i=0;i<n;i++) {
            heap.offer(new int[] {scan.nextInt(),scan.nextInt()-1});
        }
        scan.close();
        int max = 0;
        PriorityQueue<int []> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        while(!heap.isEmpty()) {//倒出堆里的元素
            int[] now = heap.poll();
            if(!queue.isEmpty() && queue.peek()[1]<now[0]){
                queue.poll();
            }
            queue.offer(now);
            max = Math.max(max, queue.size());
        }
        System.out.println(max);
    }
}