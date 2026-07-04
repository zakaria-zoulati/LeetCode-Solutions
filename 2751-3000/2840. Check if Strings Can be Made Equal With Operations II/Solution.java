class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length() ; 
        int[] f1 = new int[26] ; 
        for( int i=0 ; i<n ; i += 2 ){
            f1[ s2.charAt(i) - 'a' ]-- ; 
            f1[ s1.charAt(i) - 'a' ]++ ; 
        } 
        for( int i=0 ; i<26 ; ++i ){
            if( f1[i] != 0 ) return false ; 
        }
        int[] f2 = new int[26] ;
        for( int i=1 ; i<n ; i += 2 ){
            f2[ s2.charAt(i) - 'a' ]-- ; 
            f2[ s1.charAt(i) - 'a' ]++ ; 
        } 
        for( int i=0 ; i<26 ; ++i ){
            if( f2[i] != 0 ) return false ; 
        }
        return true ; 
    }
}