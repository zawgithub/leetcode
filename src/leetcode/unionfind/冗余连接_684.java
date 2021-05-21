package leetcode.unionfind;

import java.util.HashMap;
import java.util.Map;

public class 冗余连接_684 {
    public static void main(String[] args) {

    }

    /**
     * 将有环的无向图去掉一条边,使其变为树
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        Map<Integer,Integer> father = new HashMap<>();
        Map<Integer,Integer> rank = new HashMap<>();
        for (int i=0;i<n;i++){
            father.put(edges[i][0], edges[i][0]);
            father.put(edges[i][1], edges[i][1]);
            rank.put(edges[i][0], 0);
            rank.put(edges[i][1], 0);
        }
        for (int i=0;i<n;i++){
            int[] temp = union(father, rank, edges[i][0], edges[i][1]);
            if (temp!=null){
                res=temp;
            }
        }
        return res;
    }

    public static int find(Map<Integer, Integer> father, int x) {
        if (x != father.get(x)) {
            father.put(x, find(father, father.get(x)));
        }
        return father.get(x);
    }

    public static int[] union(Map<Integer, Integer> father, Map<Integer, Integer> rank, int a, int b) {
        int x = find(father, a);
        int y = find(father, b);
        if (x == y){
            return new int[]{a, b};
        }

        int rankX=rank.get(x);
        int rankY=rank.get(y);
        if (rankX > rankY) {
            father.put(y, x);
        } else {
            if (rankX == rankY) {
                rank.put(y, rank.get(y)+1);
            }
            father.put(x, y);
        }
        return null;
    }
}
