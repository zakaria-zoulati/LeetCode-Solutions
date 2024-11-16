class Solution {
    public String convert(String s, int numRows) {
        int n = s.length() ;
        if (numRows == 1 ) return s;
      
        StringBuilder rs = new StringBuilder() ; 
        numRows-- ; 
        for( int i=0 ; i<n ; i+= 2*numRows ){
            rs.append( s.charAt(i) ) ; 
        }
        for( int i=1 ; i<numRows ; ++i ){
            int t = 0 ;
            int next = i ; 
            while( next < n ){
                rs.append( s.charAt(next) ) ; 
                ++t ; 
                if( t%2 == 1 ){
                    next = t*numRows + numRows - i ; 
                }else {
                    next =  t*numRows + i ; 
                }
            }
        }
        for( int i= numRows ; i<n ; i+=2*numRows ){
            rs.append( s.charAt(i) ) ; 
        }
        return rs.toString();
    }
}
