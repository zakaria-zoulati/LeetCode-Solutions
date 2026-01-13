class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        int[] f = new int[10] ; 
        int bulls = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( secret.charAt(i) == guess.charAt(i) ){
                bulls++ ; 
            }else {
                f[ secret.charAt(i) - '0' ]++ ;
            }
        }
        rs.append( bulls ) ; 
        rs.append( 'A' ) ; 
        int cows = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( secret.charAt(i) != guess.charAt(i) && f[ guess.charAt(i) - '0' ]-- > 0 ){
                cows++ ; 
            }
        }
        rs.append( cows ) ; 
        rs.append( 'B' ) ; 

        return  rs.toString() ; 
    }
}