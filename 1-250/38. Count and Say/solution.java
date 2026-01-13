class Solution {
    public String countAndSay(int n) {
        StringBuilder rs = new StringBuilder() ;
        rs.append("1") ; 
        for( int i=2 ; i<=n ; ++i ){
            StringBuilder inter = new StringBuilder() ; 
            int len = rs.length() ; 
            for( int j=0 ; j<len ; ++j ){
                int co = 1; 
                char c = rs.charAt(j) ; 
                while( j+1<len && rs.charAt(j+1) == c ){
                    ++j ; 
                    ++co ;
                }
                inter.append( co ) ; 
                inter.append( c ) ; 
            }
            rs = inter ; 
        } 
        return rs.toString();
    }
}