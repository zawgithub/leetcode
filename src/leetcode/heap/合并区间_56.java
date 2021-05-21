package leetcode.heap;

import java.util.*;

public class 合并区间_56 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        int[][] res=merge(new int[][]{{1,4},
                                      {0,0}});
        int a = 1;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][0];
        }
        Queue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        for (int i=0;i<intervals.length;i++){
            heap.offer(new Interval(intervals[i][0], intervals[i][1]));
        }
        List<Interval> res = new ArrayList<>();
        res.add(heap.poll());
        while (!heap.isEmpty()){
            Interval interval = heap.poll();
            int start = res.get(res.size()-1).start;
            int end = res.get(res.size()-1).end;
            if (interval.start>end){
                res.add(interval);
            }
            else {
                res.set(res.size()-1, new Interval(start, Math.max(end, interval.end)));
            }
        }
        int[][] resArr = new int[res.size()][2];
        for (int i=0;i<res.size();i++){
            resArr[i][0]=res.get(i).start;
            resArr[i][1]=res.get(i).end;
        }
        return resArr;
    }
}
