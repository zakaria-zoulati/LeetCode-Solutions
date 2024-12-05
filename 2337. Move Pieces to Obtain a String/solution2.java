class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length() ; 
        char[] f = start.toCharArray() ; 
        char[] t = target.toCharArray() ; 
        int i = 0 ; 
        int j = 0 ; 
        while( i<=n && j<=n  ){
            while( i<n && f[i] == '_' ) ++i ; 
            while( j<n && t[j] == '_' ) ++j ; 
            if( i==n || j==n ){
                return i==n && j==n ; 
            }
            if( f[i] !=  t[j] ) return false ; 
            else if( f[i] == 'L' && i<j ){
                return false  ; 
            }else if( f[i] == 'R' && j<i ){
                return false ;
            }
            ++i ; 
            ++j ;
        }
        return true  ; 
    }
}