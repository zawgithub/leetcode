package leetcode.unionfind;

public class 朋友圈_547 {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},
                                  {1,1,0},
                                  {0,0,1}}));
    }

    /**
     * 连通图的个数
     * 并查集
     * @param num
     * @return
     */
    public static int findCircleNum(int[][] num) {
        // 最初朋友圈的个数
        int count = num.length;
        int father[] = new int[num.length];
        // 存储每个节点的秩,树的层数
        int rank[] = new int[num.length];
        // 初始化父节点，father[x]=y表示x的父节点是y
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        for (int i = 0; i < father.length-1; i++) {
            for (int j = i+1; j < father.length; j++) {
                if (num[i][j] == 1){
                    count = union(father, rank, i, j, count);
                }

            }
        }
        return count;
    }

    public static int find(int[] father, int x) {
        if (x != father[x]) {
            father[x] = find(father, father[x]); // 这个回溯时的压缩路径是精华
        }
        return father[x];
    }

    public static int union(int[] father, int[] rank, int x, int y, int count) {
        x = find(father, x);
        y = find(father, y);
        if (x == y){
            return count;
        }

        if (rank[x] > rank[y]) {
            father[y] = x;
        } else {
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
            father[x] = y;
        }
        // 每次朋友圈合并，将朋友圈个数减1
        count--;
        return count;
    }
}
