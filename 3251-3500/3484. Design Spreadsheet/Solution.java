class Spreadsheet {
    int[][] grid ;
    public Spreadsheet(int rows) {
        this.grid = new int[rows+1][26]  ;
    }
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A' ; 
        int row = 0 ; 
        for( int i=1 ; i<cell.length() ; ++i ){
            row = row*10 + ( cell.charAt(i) - '0' ) ; 
        }
        grid[row][col] = value ; 
    }
    
    public void resetCell(String cell) {
        setCell( cell , 0 ) ; 
    }

    public int getValue(String formula) {
        int i=1 ;
        for( ; i<formula.length() ; ++i ){
            if( formula.charAt(i) == '+' ) break ; 
        }
        return evaluate( formula.substring(1,i) ) + evaluate( formula.substring(i+1) ) ; 
    }

    public int evaluate( String s ){
        if( s.charAt(0) > '9' || s.charAt(0) < '0' ){
            int col = s.charAt(0) - 'A' ; 
            int row = 0 ; 
            for( int i=1 ; i<s.length() ; ++i ){
                row = row*10 + ( s.charAt(i) - '0' ) ; 
            }
            return grid[row][col] ; 
        }else {
            int rs = 0 ; 
            for( char c : s.toCharArray() ){
                rs = rs*10 + ( c - '0' ) ; 
            }
            return rs ; 
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */