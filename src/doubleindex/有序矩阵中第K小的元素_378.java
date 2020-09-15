package doubleindex;

import java.util.PriorityQueue;

public class 有序矩阵中第K小的元素_378 {

//    给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//    请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,2},{1,3}}, 2));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //l r记录矩阵matrix的最小最大值
        int l=matrix[0][0];
        int r=matrix[n-1][n-1];
        while (l<r){
            int mid=(l+r)/2;
            if(getNum(matrix,mid)<k){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * 在矩阵m中找 小于等于mid的数的个数num
     * @param m
     * @param mid
     * @return
     */
    public static int getNum(int[][] m, int mid){
        int num = 0;
        //从矩阵左下角开始找,i j记录横纵坐标
        int n = m.length;
        int i=n-1,j=0;
        while (i>=0&&j<n){
            if (m[i][j]<=mid){
                num+=i+1;
                j++;
            }else {
                i--;
            }
        }
        return num;
    }
}