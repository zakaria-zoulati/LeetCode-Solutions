class Solution {
    public boolean check( int[] f , long m , int cars ){
        long curr = 0L ; 
        for( int i=1 ; i<101 && curr<cars ; ++i ){
            if( f[i] == 0 ) continue ; 
            long val = (long) Math.sqrt( m/i ) ; 
            curr += val*f[i] ; 
        }
        return cars <= curr ; 
    }
    public long repairCars(int[] ranks, int cars) {
        int[] f = new int[101] ; 
        long r = ranks[0] ;  
        for( int i : ranks ){
            r = Math.min( r , i ) ; 
            f[i]++ ; 
        }
        long l = r ; 
        r *= (long) cars*cars ; 
        while( l < r ){
            long mid = l + ( r - l )/2 ;
            if( check( f , mid , cars ) ){
                r = mid ; 
            }else {
                l = mid+1 ; 
            }
        }
        return r ; 
    }
}