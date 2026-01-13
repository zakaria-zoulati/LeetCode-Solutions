class NeighborSum {
    int[][] grid ; 
    int n = 0 ;
    int[] adj  ;
    int[] diag ;
    public NeighborSum(int[][] grid) {
        this.grid = grid ; 
        this.n = grid.length ; 
        adj = new int[n*n]; 
        diag =  new int[n*n] ; 
        compute( grid , adj , diag ) ; 
    }
    public void compute( int[][] grid  , int[] adj , int[] diag ){
        for(int i=0 ; i<n ; ++i){
            for(int j=0 ; j<n ; j++ ){
                boolean up = i-1 >=0 ; 
                boolean down = i+1 <n ; 
                boolean right = j+1 <n ; 
                boolean left = j-1 >=0 ; 
                // Updates The Adjacent values map
                if( down ){
                   adj[ grid[i][j] ] +=  grid[i+1][j]  ;    
                }
                if( up ){
                    adj[ grid[i][j] ] +=  grid[i+-1][j]  ; 
                }
                if( right  ){
                    adj[ grid[i][j] ] +=  grid[i][j+1]  ; 
                }
                if( left ){ 
                    adj[ grid[i][j] ] +=  grid[i][j-1]  ; 
                }
                // Updates The diagonal values map 
                if( up ){
                        if(left){  
                            diag[ grid[i][j] ] += grid[i-1][j-1] ; 
                        }
                        if(right ){ 
                             diag[ grid[i][j] ] += grid[i-1][j+1] ; 
                        }
                    }
                if( down ){
                        if(left){
                             diag[ grid[i][j] ] += grid[i+1][j-1] ; 
                        }
                        if( right ){
                             diag[ grid[i][j] ] += grid[i+1][j+1] ; 
                        }
                }
            }
        }
    }
    public int adjacentSum(int value) {
        return adj[value]  ; 
    }
    
    public int diagonalSum(int value) {
        return diag[value] ; 
    }
}

