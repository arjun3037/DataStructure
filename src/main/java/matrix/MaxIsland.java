package matrix;

public class MaxIsland {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int count=0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1){
                    // run DFS
                    count = Math.max(count , dfs(i,j,arr)) ;
                }
            }
        }
        System.out.println(count);
    }

    private static int dfs(int i, int j, int[][] arr) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 1){
            return 0;
        }
        arr[i][j]=-1;
        return 1+ dfs(i+1,j,arr)+dfs(i-1,j,arr)+dfs(i,j-1,arr)+dfs(i,j+1,arr);
    }

}
