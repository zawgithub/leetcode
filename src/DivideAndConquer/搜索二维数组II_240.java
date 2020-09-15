package DivideAndConquer;

public class 搜索二维数组II_240 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        while (i<=matrix.length-1&&j>=0){
            if (matrix[i][j]==target){
                return true;
            }
            else if (matrix[i][j]>target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
