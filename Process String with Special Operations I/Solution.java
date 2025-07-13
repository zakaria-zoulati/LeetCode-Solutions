class Solution {
    public String processStr(String s) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) == '*' ){
                if( rs.length() != 0 ){
                    rs.deleteCharAt( rs.length() -1  ) ;
                }
            }else if( s.charAt(i) == '#' ){
                rs.append( rs ) ; 
            }else if( s.charAt(i) == '%' ){
                rs.reverse() ; 
            }else {
                rs.append( s.charAt(i) ) ; 
            }
        }
        return rs.toString() ; 
    }
}