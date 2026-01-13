class NumMatrix {
    int[][] arr ; 
    public NumMatrix(int[][] matrix) {
        this.arr = matrix ; 
        int n = arr.length ; 
        int m = arr[0].length ; 
        for(int i=0 ; i<n ; ++i){   
            for(int j=0 ; j<m ; ++j){
                if( i+1 < n ){
                    arr[i+1][j] += arr[i][j] ; 
                }
                if( j!=0  ){
                    arr[i][j] += arr[i][j-1] ; 
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       int rs = 0 ; 
       if( row1 == 0 ){
            if( col1 == 0 ){
                rs = arr[row2][col2] ; 
                return rs ; 
            }else {
                rs = arr[row2][col2] - arr[row2][col1-1] ; 
                return rs ; 
            }
       }else {
           if( col1 == 0 ) {
              rs = arr[row2][col2] - arr[row1-1][col2] ; 
              return rs ; 
           }else {
              rs = (  arr[row2][col2] - arr[row2][col1-1] ) - (  arr[row1-1][col2] - arr[row1-1][col1-1] )  ; 
              return rs ; 
           }
       }
 
    }
}
