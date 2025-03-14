class Solution {
    public boolean check( int[] candies, int m , long k ){
        int i = candies.length-1 ;
        while(i >= 0){
            k -= candies[i--]/m ; 
        }
        return k<=0L ; 
    }
    public int maximumCandies(int[] candies, long k) {
        int n  = candies.length ; 
        int max = -1 ; 
        long sum = 0L ; 
        for( int i : candies ){
            if( i > max ) max = i ; 
            sum += i ; 
        }
        if( sum < k ) return 0 ; 
        int l = 1 ; 
        int r = (int) (sum/k) ; 
        while( l <= r ){
            int mid = l + (( r-l ) >> 1 ) ; 
            if( check( candies, mid , k ) ){
                l = mid + 1  ;  
            }else {
                r = mid - 1 ; 
            }
        }
        return r ; 
    }
}