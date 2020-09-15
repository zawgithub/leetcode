package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N皇后_51 {
    public static void main(String[] args) {
        solveNQueens(8);
    }
    public static List<List<String>> solveNQueens(int n) {
        boolean[] visitedCol = new boolean[n];  //j
        boolean[] visited45 = new boolean[2*n-1]; //i-j+n-1
        boolean[] visited135 = new boolean[2*n-1]; //i+j

        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(res, temp, n, visitedCol, visited45,visited135, 0);

        return res;
    }
    public static void dfs(List<List<String >> res, List<String> temp, int n, boolean[] visitedCol, boolean[] visited45, boolean[] visited135, int row){
        if (temp.size()==n){
            List<String> tempCopy = new ArrayList<>(Arrays.asList(new String[temp.size()]));
            Collections.copy(tempCopy, temp);
            res.add(tempCopy);
        }
        for (int col=0;col<n;col++){
            if (row<n&&!visitedCol[col]&&!visited45[row-col+n-1]&&!visited135[row+col]){
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<n;i++){
                    if (i==col){
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
                visitedCol[col]=true;
                visited45[row-col+n-1]=true;
                visited135[row+col]=true;
                dfs(res, temp, n, visitedCol, visited45, visited135, row+1);
                temp.remove(temp.size()-1);
                visitedCol[col]=false;
                visited45[row-col+n-1]=false;
                visited135[row+col]=false;
            }
        }
    }
}
