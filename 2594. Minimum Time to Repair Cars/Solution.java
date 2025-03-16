class Solution {
    public boolean check( int[] ranks , long m , int cars ){
        long curr = 0L ; 
        for( int i : ranks ){
            curr += (long) Math.sqrt( m/i ) ; 
        }
        return cars <= curr ; 
    }
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length ; 
        long l = 1L ; 
        long r = ranks[0] ;  
        for( int i : ranks ){
            r = Math.min( r , i ) ; 
        }
        r *= (long) cars*cars ; 
        while( l < r ){
            long mid = l + ( r - l )/2 ;
            if( check( ranks , mid , cars ) ){
                r = mid ; 
            }else {
                l = mid+1 ; 
            }
        }
        return r ; 
    }
}