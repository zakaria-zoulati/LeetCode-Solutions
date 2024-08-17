class Solution {
    public int count( char[][] grid , int i , int j ){  
        int inter = 0  ; 
        for(int  p=i ; p<i+2 ; ++p){
            for(int k = j; k<j+2 ; ++k){
                if( grid[p][k] == 'B' ) inter++ ;
            }
        }
        return inter ; 
    }
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<2 ;++i){
            for(int j=0 ; j<2 ;++j){
                if( count( grid , i , j ) !=2  ) return true ; 
            }
        }
        return false ; 
    }
}