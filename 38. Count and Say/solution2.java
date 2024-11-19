class Solution {
    public String countAndSay(int n) {
        if( n == 1 ) return "1" ;  
        String p = countAndSay(n-1) ; 
        StringBuilder rs = new StringBuilder() ; 
        int len = p.length() ; 
        for( int j=0 ; j<len ; ++j ){
            int co = 1; 
            char c = p.charAt(j) ; 
            while( j+1<len && p.charAt(j+1) == c ){
                ++j ; 
                ++co ;
            }
            rs.append(co); 
            rs.append(c); 
        }
        return rs.toString();
    }
}