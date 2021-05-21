package leetcode.dfs;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/21
 */
public class 单词搜索_79 {
//    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
//    同一个单元格内的字母不允许被重复使用。
//    示例:
//
//    board =
//            [
//            ['A','B','C','E'],
//            ['S','F','C','S'],
//            ['A','D','E','E']
//            ]
//
//    给定 word = "ABCCED", 返回 true
//    给定 word = "SEE", 返回 true
//    给定 word = "ABCB", 返回 false
//
//    提示：
//
//    board 和 word 中只包含大写和小写英文字母。
//            1 <= board.length <= 200
//            1 <= board[i].length <= 200
//            1 <= word.length <= 10^3

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dfs(board, new boolean[m][n], word, 0, 0, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (board[i][j]!=word.charAt(k)) return false;
        if (k==word.length()-1) return true;
        int[][] direction = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean result = false;
        for (int[] dir:direction) {
            int i1 = i+dir[0];
            int j1 = j+dir[1];
            if (i1>=0&&i1<board.length&&j1>=0&&j1<board[0].length&&!visited[i1][j1]) {
                visited[i1][j1] = true;
                boolean flag = dfs(board, visited, word, i1, j1, k + 1);
                visited[i1][j1] = false;
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
