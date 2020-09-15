package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhaoanwei
 * @Date: 2020/8/10
 */
public class 判断二分图_785 {

//    给定一个无向图graph，当这个图为二分图时返回true。
//
//    如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
//
//    graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

//    示例 1:
//    输入: [[1,3], [0,2], [1,3], [0,2]]
//    输出: true
//    解释:
//    无向图如下:
//            0----1
//            |    |
//            |    |
//            3----2
//    我们可以将节点分成两组: {0, 2} 和 {1, 3}。

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        //-1和1标记两个组,0为未分组
        int[] group = new int[len];
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int j=0;j<len;j++){
            if (group[j]==0){
                queue.offer(j);
                //首节点分到-1组
                group[j]=-1;
                while (!queue.isEmpty()){
                    int num = queue.poll();
                    for (int i=0;i<graph[num].length;i++){
                        int a = graph[num][i];
                        if (group[a]==group[num]){
                            return false;
                        }
                        if (group[a]==0){
                            group[a]=-group[num];
                            queue.offer(a);
                        }

                    }
                }
            }
        }
        return true;
    }
}
