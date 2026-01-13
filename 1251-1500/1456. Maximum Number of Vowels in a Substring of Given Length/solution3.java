class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length() ; 
        int[] score = new int['z'+1] ; 
        score[ 'a' ] = 1 ; 
        score[ 'e' ] = 1 ; 
        score[ 'u' ] = 1 ; 
        score[ 'i' ] = 1 ; 
        score[ 'o' ] = 1 ; 
        int curr = 0 ; 
        int rs = 0 ; 
        for( int i=0 ; i<k ; ++i ){
            curr += score[ s.charAt(i) ] ; 
        }
        rs = curr ; 
        for( int i=k ; i<n ; ++i ){
            curr += score[ s.charAt(i)  ] ;  
            curr -= score[ s.charAt(i-k) ] ;  
            rs = Math.max( rs , curr ) ; 
        }
        return rs ; 
    }
}