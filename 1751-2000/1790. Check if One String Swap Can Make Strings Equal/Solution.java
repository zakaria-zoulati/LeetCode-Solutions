class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length() ; 
        int count = 0 ; 
        for( int i=0 ; i<n ; ++i){
            if( s1.charAt(i) != s2.charAt(i) ) count++ ; 
        }
        if( count == 0 ) return true ; 
        if( count != 2 ) return false  ; 
        int l = 0 ; 
        int r = n-1; 
        while( s1.charAt(l) == s2.charAt(l) ) l++  ;
        while( s1.charAt(r) == s2.charAt(r) ) r-- ;
        return s1.charAt(l) == s2.charAt(r) && s2.charAt(l) == s1.charAt(r) ;
    }
}