class solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 ) return s ; 
        int n = s.length() ;
        StringBuilder rs = new StringBuilder() ; 
        StringBuilder[] grid = new StringBuilder[numRows] ; 
        for( int i=0 ; i<numRows ; ++i ){
            grid[i] = new StringBuilder() ; 
        }
        boolean flag = false ; 
        numRows-- ; 
        for( int i=0 ; i<n ; ++i ){
            if( i%numRows == 0 ){
                flag = !flag ; 
                if( !flag ){
                    grid[ numRows ].append(s.charAt(i)) ; 
                }else {
                    grid[0].append(s.charAt(i)) ; 
                } 
            }else if( flag ) {
                grid[ i%numRows ].append(s.charAt(i)) ; 
            }else {
                grid[numRows-i%numRows].append(s.charAt(i)) ; 
            }
        }
        for( StringBuilder r : grid ){
            rs.append( r ) ; 
        }
        return rs.toString() ; 
    }
}