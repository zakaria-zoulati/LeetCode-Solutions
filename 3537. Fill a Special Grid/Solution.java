class Solution {
    int ele ; 
    public void fill( int[][] grid ,  int i ,int j , int f  ){
        if( f == 1 ){
            grid[i][j] = ele-- ; 
            return ; 
        } 
        fill( grid , i , j , f/2) ; 
        fill( grid , i + f/2 ,j , f/2 ) ; 
        fill(  grid , i+f/2 , j+f/2 , f/2  ) ; 
        fill( grid , i , j +f/2 , f/2   ) ; 
    }
    public int[][] specialGrid(int n) {
        int m = 1 << n ; 
        int[][] grid = new int[m][m] ; 
        if( n == 0 ) return grid ; 
        ele = m*m - 1; 
        fill( grid , 0 , 0 , m ) ; 
        return grid ; 
    }
}