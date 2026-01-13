class Solution {
    public int minFlips(String t) {
        int n = t.length() ;  
        int rs = 0 ; 
        char prev = t.charAt(0) ; 
        for( char c : t.toCharArray() ){
            if( c != prev ){
                ++rs ; 
                prev = c ; 
            }
        }
        if( t.charAt(0) == '1' ) ++rs ; 
        return rs ; 
    }
}