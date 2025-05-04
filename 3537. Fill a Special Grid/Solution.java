class Solution {
    public void fill( int[][] grid ,  int i ,int j , int f , int ele ){
        if( f == 1 ){
            grid[i][j] = ele ; 
            return ; 
        } 
        fill( grid , i , j , f/2 , ele ) ; 
        fill( grid , i + f/2 ,j , f/2 , ele - f*f/4 ) ; 
        fill(  grid , i+f/2 , j+f/2 , f/2 , ele - f*f/2  ) ; 
        fill( grid , i , j +f/2 , f/2 , ele - 3*f*f/4  ) ; 
    }
    public int[][] specialGrid(int n) {
        int m = 1 << n ; 
        int[][] grid = new int[m][m] ; 
        if( n == 0 ) return grid ; 
        fill( grid , 0 , 0 , m , m*m -1 ) ; 
        return grid ; 
    }
}