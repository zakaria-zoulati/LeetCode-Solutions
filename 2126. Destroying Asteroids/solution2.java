class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a ) {
        long curr = mass ; 
        int max = 0; 
        for( int num : a ){
            if( num > max ){
                max = num ; 
            }
        }
        int[] count = new int[ max+1 ] ; 
        for(int num : a){
            count[ num ]++ ; 
        }
        for(int i=1 ; i<=max ; ++i ){
            if( curr < i ) return false ; 
            curr += ( (long) count[i] )*i ; 
        }
        return true ; 
    }
}