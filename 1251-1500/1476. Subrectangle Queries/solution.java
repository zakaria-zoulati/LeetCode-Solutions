class SubrectangleQueries {
    int[][] matrix ;
    public SubrectangleQueries(int[][] rectangle) {
        this.matrix = rectangle ; 
    }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        while( row1<=row2 ){
            int a = col1 ; 
            int b = col2 ; 
            while( a<=b ){
                matrix[row1][a] = newValue ; 
                ++a ;
            }
            row1++ ; 
        }
    }
    
    public int getValue(int row, int col) {
        int val = matrix[row][col] ; 
        return val ;
    }
}

