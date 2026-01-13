class Solution {
    public boolean isMagic( int[][] grid ,int rStart ,int cStart ){
        HashSet<Integer> set = new HashSet<>() ; 
        for(int i=0 ; i<3 ;++i){
            int inter = 0 ;
            for(int j=0 ; j<3 ;++j){
                if( grid[rStart+i][cStart+j] > 9   ||  grid[rStart+i][cStart+j] == 0  || set.contains(  grid[rStart+i][cStart+j] ) ){
                    return false ;
                }
                set.add(  grid[rStart+i][cStart+j] ) ; 
                inter += grid[rStart+i][cStart+j] ;
            }
            if( inter != 15 ) return false ; 
        }
        int col1 = grid[rStart][cStart] + grid[rStart+1][cStart] + grid[rStart+2][cStart] ; 
        if( col1 != 15 )  return false ;
        int col2 = grid[rStart][cStart+1] + grid[rStart+1][cStart+1] + grid[rStart+2][cStart+1] ; 
        if( col2 != 15 )  return false ; 
        int dia1 = grid[rStart][cStart] + grid[rStart+1][cStart+1] + grid[rStart+2][cStart+2] ; 
        if( dia1 != 15 ) return false ;

        
        return true ; 
    }
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length ; 
        int col = grid[0].length  ;
        if( row <3 || col < 3 ) return 0 ; 
        int rs = 0 ; 
        for(int i= 0 ;i+2<row ; ++i){
           for(int j=0 ; j+2<col ; ++j ){
                if( isMagic( grid , i , j ) ) rs++ ;
           }
        }
        return rs ; 
    }
}