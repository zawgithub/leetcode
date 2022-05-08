package leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {

    private Deque<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        if (queue.isEmpty()) {
            queue.offer(t);
            return 1;
        }
        queue.offer(t);
        Integer last = queue.getLast();
        while (last - 3000 > queue.getFirst()) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
