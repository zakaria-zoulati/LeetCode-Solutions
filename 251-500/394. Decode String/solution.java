class Solution {
    public String decodeString(String s) {
        StringBuilder rs = new StringBuilder() ; 
        int n = s.length() ; 
        for( int i=0 ; i<n ; ++i ){
            char c = s.charAt(i) ; 
            if( c < '0' || c > '9' ){
                rs.append( c ) ; 
                continue ; 
            }
            int num = c - '0' ; 
            while( i+1 < n && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' ){
                num = num*10 + ( s.charAt(i+1) - '0' ) ; 
                ++i ; 
            }
            int co = 1 ; 
            StringBuilder inter = new StringBuilder() ; 
            i += 2 ; 
            while( i<n ){
                if( s.charAt(i) == '[' ) co++ ; 
                else if( s.charAt(i) == ']' ) co-- ; 
                if( co == 0 ){
                    rs.append( decodeString(inter.toString()).repeat(num) ) ; 
                    break ; 
                }else {
                    inter.append( s.charAt(i) ) ; 
                    ++i ; 
                }             
            }
        }
        return rs.toString() ; 
    }
}