package matrix;

public class FloodFill {

    public static void main(String[] args) {
        /**
         * [[0,0,0],[0,1,1]]
         * 1
         * 1
         * 1
         */
        //int[][] arr = new int[][]{{1,1,1},{1,1,0},{1,0,1}};

        int[][] arr = new int[][]{{0,0,0},{0,1,1}};

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int[][] ints = floodFill(arr, 1, 1, 1 , visited);

        for(int i = 0 ; i < ints.length ; i++){
            for(int j = 0 ; j < ints[0].length ; j++){
                System.out.print(ints[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor , boolean[][] visited) {
        int sourceColor = image[sr][sc];
        return dfs(sr,sc,image,newColor , sourceColor , visited);
    }
    private static int[][] dfs(int i , int j , int[][] arr , int color , int source , boolean[][] visited){

        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j]){
            return arr;
        }

        if(arr[i][j] == source){
            arr[i][j]= color;
            visited[i][j]=true;
        }


        arr = dfs(i+1,j,arr,color,source,visited);
        arr = dfs(i-1,j,arr,color,source,visited);
        arr = dfs(i,j+1,arr,color,source,visited);
        arr = dfs(i,j-1,arr,color,source,visited);

        return arr;

    }
}
