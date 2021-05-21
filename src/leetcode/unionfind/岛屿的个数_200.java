package leetcode.unionfind;

public class 岛屿的个数_200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1'},{'1'}}));
    }
    public static int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0){
            return 0;
        }
        int n=grid[0].length;
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                }
            }
        }
        int[] father = new int[m*n];
        int[] rank = new int[m*n];
        for (int i=0;i<father.length;i++){
            father[i]=i;
        }
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (j>0){
                    if (grid[i][j]=='1'&&grid[i][j-1]=='1'){
                        count = union(father, rank, i*n+j, i*n+j-1, count);
                    }
                }
                if (i>0){
                    if (grid[i][j]=='1'&&grid[i-1][j]=='1'){
                        count = union(father, rank, i*n+j, (i-1)*n+j, count);
                    }
                }
            }
        }
        return count;
    }
    public static int find(int x, int[] father){
        int a=1;
        if (x!=father[x]){
            father[x]=find(father[x], father);
        }
        return father[x];
    }

    public static int union(int[] father, int[] rank, int x, int y, int count){
        x=find(x,father);
        y=find(y,father);
        if (x==y){
            return count;
        }
        if (rank[x]<rank[y]){
            father[x]=y;
        }
        else {
            if (rank[x]==rank[y]){
                rank[x]++;
            }
            father[y]=x;
        }
        count--;
        return count;
    }
}
