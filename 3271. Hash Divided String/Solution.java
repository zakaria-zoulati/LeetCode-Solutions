class Solution {
    public String stringHash(String s, int k) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        for( int i=0 ; i<=n-k ; i += k ){
            int curr = 0 ; 
            for( int j=i ; j<i+k ; ++j ){
                curr += s.charAt(j) - 'a' ; 
            }
            curr %= 26 ; 
            char c = (char) ('a' + curr) ; 
            rs.append( c ) ; 
        }
        return rs.toString() ; 
    }
}