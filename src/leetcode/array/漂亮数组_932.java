package leetcode.array;

public class 漂亮数组_932 {
    public static void main(String[] args) {

    }
    public int[] beautifulArray(int N){
        if (N==1){
            return new int[]{1};
        }

        int[] left = beautifulArray((N+1)/2);
        int[] right = beautifulArray(N/2);
        int[] res = new int[N];
        for (int i=0;i<(N+1)/2;i++){
            res[i]=2*left[i]-1;
        }
        for (int i=(N+1)/2;i<N;i++){
            res[i]=2*right[i-(N+1)/2];
        }
        return res;
    }
}
