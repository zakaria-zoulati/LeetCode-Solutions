class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        long sum = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                sum += grid[i][j] ; 
            }
        }

        if( n == 1 ){
            long pref = 0 ; 
            for( int i=0 ; i<m ; ++i ){
                if( pref * 2 + grid[0][i] == sum ) return true ; 
                pref += grid[0][i] ; 
                if( pref * 2 == sum ) return true ; 
                if( sum - pref == pref - grid[0][0] ) return true ; 
                if( pref == sum - pref - grid[0][m-1] ) return true ; 
            }
            return false ; 
        }
        if( m == 1 ){
            long col = 0 ; 
            for( int i=0 ; i<n ; ++i ){
                if( col * 2 + grid[i][0] == sum ) return true ; 
                col += grid[i][0] ; 
                if( col * 2 == sum ) return true ; 
                if( sum - col == col - grid[0][0] ) return true ; 
                if( col == sum - col - grid[n-1][0] ) return true ; 
            }
            return false ; 
        }

        
        int l = 100_001 ; 
        int[] set = new int[l] ; 


        long h = 0 ;
        for( int i=0 ; i<n-1 ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                h += grid[i][j] ; 
                set[ grid[i][j] ] = 1 ; 
            }   
            if( h * 2 == sum ) return true ;  
            else if( h * 2 > sum && 2*h - sum < l && set[(int)(2*h-sum)] == 1 ) {
                if( i > 0 ) {
                    return true ; 
                }
                int val = (int) ( 2*h - sum ) ; 
                if( grid[0][0] == val || grid[0][m-1] == val ) return true ; 
            }
        }
        h = 0 ; 
        for( int i=n-1 ; i>0 ; --i ){
            for( int j=0 ; j<m ; ++j ){
                h += grid[i][j] ; 
                set[ grid[i][j] ] = 2 ; 
            }   
            if( h * 2 > sum && 2*h - sum < l && set[(int)(2*h-sum)] == 2 ) {
                if( i < n-1 ){
                    return true ; 
                }
                int val = (int) ( 2*h - sum ) ; 
                if( grid[n-1][0] == val || grid[n-1][m-1] == val ){
                    return true ; 
                }
            }
        }

        long v = 0 ; 
        for( int j=0 ; j<m-1 ; ++j ){
            for( int i=0 ; i<n ; ++i ){ 
                v += grid[i][j] ; 
                set[ grid[i][j] ] = 3 ; 
            }
            if( v * 2 == sum ) return true ;  
            else if( v * 2 > sum && 2*v - sum < l && set[(int)(2*v-sum)] == 3 ) {
                if( j > 0 ) {
                    return true ; 
                }
                int val = (int) ( 2*v - sum ) ; 
                if( grid[0][0] == val || grid[n-1][0] == val ) {
                    return true ; 
                }
            }
        }
        v = 0 ; 
        for( int j=m-1 ; j>0 ; --j ){
            for( int i=0 ; i<n ; ++i ){ 
                v += grid[i][j] ; 
                set[ grid[i][j] ] = 4 ; 
            }
            if( v * 2 > sum && 2*v - sum < l && set[(int)(2*v-sum)] == 4 ) {
                if( j < m-1 ){
                    return true ; 
                }
                int val = (int) ( 2*v-sum ) ; 
                if( grid[0][m-1] == val || grid[n-1][m-1] == val ) return true ; 
            }
        }

        return false ; 
    }
}