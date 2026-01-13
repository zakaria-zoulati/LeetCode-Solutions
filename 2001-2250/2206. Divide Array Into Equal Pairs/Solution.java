class Solution {
    public boolean divideArray(int[] nums) {
        int[] f = new int[501] ; 
        for( int i : nums ){ f[i]++ ; }
        for( int i=1 ; i<501 ; ++i ){ if( f[i]%2==1 ) return false ; } 
        return true; 
    }
}