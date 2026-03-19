class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        int ans = 0 ; 
        boolean[] x = new boolean[m] ; 
        int[] diff = new int[m] ; 

        if( grid[0][0] == 'X' ){
            x[0] = true ; 
            diff[0] = 1 ; 
        }else if ( grid[0][0] == 'Y' ){
            diff[0] = -1 ; 
        }

        for( int i=1 ; i<m ; ++i ){
            x[i] = x[i-1] ; 
            diff[i] = diff[i-1] ;
            if( grid[0][i] == 'X' ){
                x[i] = true ; 
                diff[i]++ ; 
            }else if( grid[0][i] == 'Y' ){
                diff[i]-- ; 
            }
            if( diff[i] == 0 && x[i] ){
                ans++ ; 
            }
        }

        for( int i=1 ; i<n ; ++i ){
            int pref = 0 ; 
            if( grid[i][0] == 'X' ){
                x[0] = true  ; 
                diff[0]++ ;
                pref++ ;  
            }else if( grid[i][0] == 'Y' ) {
                diff[0]-- ;
                pref-- ;  
            }
            if( diff[0] == 0 && x[0] ){
                ans++ ; 
            }
            for(int j=1; j<m; ++j){
                if( grid[i][j] == 'X' ){
                    pref++ ; 
                    x[j] = true ; 
                }else if( grid[i][j] == 'Y' ){
                    pref-- ; 
                }
                x[j] |= x[j-1] ; 
                diff[j] += pref ; 
                if( diff[j] == 0 && x[j] ){
                    ans++ ; 
                }
            }
        }
        return ans ; 
    }
}