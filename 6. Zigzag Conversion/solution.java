class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 ) return s ; 
        int n = s.length() ;
        StringBuilder rs = new StringBuilder() ; 
        char[][] grid = new char[numRows][n-n/3] ; 
        boolean flag = false ; 
        int a = 0 ; 
        int b = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( i%(numRows-1) == 0 ){
                flag = !flag ; 
                if( !flag ){
                    grid[ numRows - 1 ][b] = s.charAt(i) ; 
                    ++b ; 
                }else {
                    grid[0][b] = s.charAt(i) ; 
                } 
            }else if( flag ) {
                grid[ i%(numRows-1) ][b] = s.charAt(i) ; 
            }else {
                grid[numRows-1-(i%(numRows-1)) ][b] = s.charAt(i) ; 
                ++b ; 
            }
        }
        for( char[] l : grid ){
            for( char c : l ){
                if( c != '\u0000' ){
                    rs.append(c) ; 
                }
            }
        }
        return rs.toString() ; 
    }
}