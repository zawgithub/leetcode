package dfs;

public class 是否存在路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited = new boolean[matrix.length];
        for (int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, visited, matrix, rows, cols, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, boolean[] visited, char[] matrix, int rows, int cols, char[] str, int k){
        int index=i*cols+j;
        if(i<0||i>=rows||j<0||j>=cols||visited[index]||str[k]!=matrix[index]){
            return false;
        }
        if (k==str.length-1){
            return true;
        }
        visited[index]=true;
        if (dfs(i+1,j,visited,matrix,rows,cols,str,k+1)
                ||dfs(i-1,j,visited,matrix,rows,cols,str,k+1)
                ||dfs(i,j+1,visited,matrix,rows,cols,str,k+1)
                ||dfs(i,j-1,visited,matrix,rows,cols,str,k+1)){
            return true;
        }
        visited[index]=false;
        return false;
    }
}
