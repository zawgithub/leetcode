package dfs;

import java.util.*;

public class 京东生日礼物 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputStr = new ArrayList<>();
        while (scanner.hasNextLine()){
            String[] strings = scanner.nextLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int w = Integer.parseInt(strings[1]);
            int h = Integer.parseInt(strings[2]);
            int[][] arr = new int[n+1][2];
            arr[0] = new int[]{w, h};
            for (int i=1;i<=n;i++){
                String[] strs = scanner.nextLine().split(" ");
                arr[i][0]=Integer.parseInt(strs[0]);
                arr[i][1]=Integer.parseInt(strs[1]);
            }
            boolean[] visited = new boolean[n+1];
            visited[0]=true;
            List<Integer> res = new ArrayList<>();
            dfs(arr, new ArrayList<Integer>(), visited, res);

            System.out.println(res.size());
            for (int i=0;i<res.size();i++){
                System.out.print(res.get(i));
                if (i<res.size()-1){
                    System.out.print(" ");
                }
                else {
                    System.out.println();
                }
            }
        }

    }
    public static void dfs(int[][] arr, List<Integer> temp, boolean[] visited, List<Integer> res){
        for (int i=1;i<arr.length;i++){
            if ((temp.isEmpty()&&arr[i][0]>arr[0][0]&&arr[i][1]>arr[0][1])||
                    (!temp.isEmpty()&&!visited[i]&&arr[i][0]>arr[temp.get(temp.size()-1)][0]&&arr[i][1]>arr[temp.get(temp.size()-1)][1])){
                temp.add(i);
                visited[i]=true;
                dfs(arr, temp, visited, res);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
        if (res.size()<temp.size()){
            List<Integer> tempCopy = new ArrayList<Integer>(Arrays.asList(new Integer[temp.size()]));
            Collections.copy(tempCopy, temp);
            res.clear();
            res.addAll(tempCopy);
        }
    }
}
