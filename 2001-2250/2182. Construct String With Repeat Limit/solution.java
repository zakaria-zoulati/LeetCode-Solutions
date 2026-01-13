class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] f = new int[26] ; 
        for( char c : s.toCharArray() ){
            f[ c - 'a' ]++  ;
        }
        StringBuilder rs = new StringBuilder() ; 
        int cl  = 25 ; 
        for( int i=cl ; i>=0 ; --i ){
            cl = Math.min( cl , i-1 ) ; 
            if( f[i] == 0 ) continue ; 
            char c = (char) ( 'a' + i ) ; 
            if( f[i] > repeatLimit ){
                int diff = 0 ; 
                while( diff++ < repeatLimit ){
                    f[i]-- ; 
                    rs.append(c) ; 
                }
                for( int j=cl; j>=0 ; --j ){
                    cl = Math.min( cl , j ) ; 
                    if( f[j] > 0 ){
                        f[j]-- ; 
                        rs.append( (char) ( 'a' + j ) ) ; 
                        ++i ; 
                        break ; 
                    }
                }
            }else {
                String ele = String.valueOf( c ).repeat( f[i] ) ;  
                rs.append( ele ) ; 
            }
        }
        return rs.toString() ; 
    }
}