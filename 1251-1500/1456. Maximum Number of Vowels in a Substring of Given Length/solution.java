class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length() ; 
        String vowels = "aeuio" ; 
        int curr = 0 ; 
        int rs = 0 ; 
        for( int i=0 ; i<k ; ++i ){
            if( vowels.indexOf( s.charAt(i) ) != -1 ){
                curr++ ; 
            }
        }
        rs = curr ; 
        for( int i=k ; i<n ; ++i ){
            if( vowels.indexOf( s.charAt(i-k) ) != -1 ){
                curr-- ; 
            }
            if( vowels.indexOf( s.charAt(i) ) != -1 ){
                curr++ ; 
                rs = Math.max( rs , curr ) ; 
            }
            
        }
        return rs ; 
    }
}