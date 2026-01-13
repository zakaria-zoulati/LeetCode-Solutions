class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length() ; 
        int[] score = new int[26] ; 
        score[ 'a' - 'a' ] = 1 ; 
        score[ 'e' - 'a' ] = 1 ; 
        score[ 'u' - 'a' ] = 1 ; 
        score[ 'i' - 'a' ] = 1 ; 
        score[ 'o' - 'a' ] = 1 ; 
        int curr = 0 ; 
        int rs = 0 ; 
        for( char c : s.substring(0,k).toCharArray()  ){
            curr += score[ c - 'a' ] ; 
        }
        rs = curr ; 
        for( int i=k ; i<n ; ++i ){
            curr += score[ s.charAt(i) - 'a' ] ;  
            curr -= score[ s.charAt(i-k) - 'a' ] ;  
            rs = Math.max( rs , curr ) ; 
        }
        return rs ; 
    }
}