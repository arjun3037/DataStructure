package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        bfs(0,0,arr.length,arr[0].length , arr);
    }

    static boolean isValid(int i , int j , int[][] arr , boolean[][] visited){
        if(i <0 || j < 0 || i >= arr.length || j >= arr[0].length){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        return true;
    }

    private static void bfs(int i, int j, int row, int col, int[][] arr) {
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        boolean[][] visited = new boolean[row][col];
        visited[i][j]=true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            System.out.print(arr[x][y]+", ");
            for(int[]d:dir){
                int tx = d[0]+x;
                int ty = d[1]+y;
                if(isValid(tx,ty,arr,visited)){
                    queue.offer(new int[]{tx,ty});
                    visited[tx][ty]=true;
                }
            }
    }
    }

}
