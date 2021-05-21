package leetcode.dfs;

public class 机器人移动范围 {
    public static void main(String[] args) {
        机器人移动范围 jzoffer = new 机器人移动范围();

        System.out.println(jzoffer.movingCount(5,10,10));

    }
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(0,0,visited,threshold,rows,cols);
    }
    public int dfs(int i, int j, boolean[][] visited,int threshold, int rows, int cols){
        if (i<0||i>=rows||j<0||j>=cols||visited[i][j]||bitSum(i)+bitSum(j)>threshold) {
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i-1,j,visited,threshold,rows,cols)
                +dfs(i,j-1,visited,threshold,rows,cols)
                +dfs(i+1,j,visited,threshold,rows,cols)
                +dfs(i,j+1,visited,threshold,rows,cols);
    }
    public int bitSum(int i){
        int sum=0;
        while (i%10!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}
