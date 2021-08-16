package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class DFSMatrixTraversal {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        dfs(0,0,visited ,arr);
    }


    private static void dfs(int i, int j, boolean[][] visited, int[][] arr) {
        if(i <0 || j < 0 || i >= arr.length || j >= arr[0].length){
            return ;
        }
        if(visited[i][j]){
            return;
        }
        System.out.print(arr[i][j]+",");
        visited[i][j]=true;
        dfs(i+1 ,j ,visited,arr); // right
        dfs(i-1 ,j ,visited,arr); // left
        dfs(i ,j+1 ,visited,arr); // top
        dfs(i ,j-1 ,visited,arr); // bottom


    }

}
