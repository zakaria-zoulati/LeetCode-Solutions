class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a ) {
        long t = mass ; 
        Arrays.sort( a ) ; 
        for(int m : a ){
            if( m > t ) return false ; 
            t += m ; 
        }
        return true ; 
    }
}