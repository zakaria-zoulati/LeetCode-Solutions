class neighborSum {
    int[][] grid ; 
    int n = 0 ;
    public neighborSum(int[][] grid) {
        this.grid = grid ; 
        this.n = grid.length ; 
    }
    
    public int adjacentSum(int value) {
        int rs = 0 ; 
        for(int i=0 ; i<n ; i++){
            for(int j=0; j<n ; j++){
                if( grid[i][j] == value ){
                    if( i+1<n  ){
                        rs += grid[i+1][j] ; 
                    }
                    if( i-1 >=0 ){
                        rs += grid[i-1][j] ; 
                    }
                     if( j+1<n  ){
                        rs += grid[i][j+1] ; 
                    }
                    if( j-1 >=0 ){
                        rs += grid[i][j-1] ; 
                    }
                    return rs ; 
                }
            }
        }
        return -1  ;
    }
    
    public int diagonalSum(int value) {
        int rs = 0 ;
        for(int i=0; i<n ; i++){
            for(int j=0; j<n ; j++){
                if( grid[i][j] == value ){
                    boolean up = i-1 >=0 ; 
                    boolean down = i+1 <n ; 
                    boolean right = j+1 <n ; 
                    boolean left = j-1 >=0 ; 
                    if( up ){
                        if(left){
                            rs += grid[i-1][j-1] ; 
                        }
                        if(right ){
                            rs += grid[i-1][j+1] ; 
                        }
                    }
                    if( down ){
                        if(left){
                            rs += grid[i+1][j-1] ; 
                        }
                        if( right ){
                            rs += grid[i+1][j+1] ; 
                        }
                    }
                    return rs ; 
                }
            }
        }
        return -1 ; 
    }
}

