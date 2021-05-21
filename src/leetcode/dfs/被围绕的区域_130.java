package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 被围绕的区域_130 {

    /**
     * 将被'X'包围的'O'变成'X'
     * @param board
     */
    public void solve(char[][] board) {
        int m=board.length;
        if (m==0){
            return;
        }
        int n=board[0].length;
        List<int[]> points = new ArrayList<>();
        for (int j=0;j<n;j++){
            if (board[0][j]=='O'){
                points.add(new int[]{0,j});
            }
            if (board[m-1][j]=='O'){
                points.add(new int[]{m-1,j});
            }
        }
        for (int i=1;i<m-1;i++){
            if (board[i][0]=='O'){
                points.add(new int[]{i,0});
            }
            if (board[i][n-1]=='O'){
                points.add(new int[]{i,n-1});
            }
        }
        for (int[] point:points){
            dfs(point[0],point[1],board);
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if (board[i][j]=='.'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
       if (i>=0&&i<board.length&&j>=0&&j<board[0].length&&board[i][j]=='O'){
           board[i][j]='.';
           dfs(i-1,j,board);
           dfs(i+1,j,board);
           dfs(i,j-1,board);
           dfs(i,j+1,board);
       }
    }
}
