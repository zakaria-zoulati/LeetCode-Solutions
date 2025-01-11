class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length() ; 
        if( n < k ){
            return false ; 
        }
        int[] f = new int[128] ; 
        int count = 0 ; 
        for( char c : s.toCharArray() ){
            f[c]++ ; 
        }
        for( int i : f ){
            if(i>0) count++; 
        }
        if( count <= k ) return true ;
        int impair = 0 ; 
        for( int i : f ){
            if( i % 2 == 1 ){
                impair++ ; 
            }
        }
        if( impair <= k  ){
            return true ; 
        }
        return false ; 
    }
}