class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        if( n == 1 ){
            long e = nums[0] ; 
            return e << k ; 
        }
        long rs = 0L ;  
        int[] r = new int[n] ; 
        int[] l = new int[n] ; 
        r[n-1] = nums[n-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            r[i] |= r[i+1] ; 
            r[i] |= nums[i] ; 
        }
        l[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            l[i] |= l[i-1] ; 
            l[i] |= nums[i] ; 
        }
        // In the case of The 0 
        long first = r[1] ; 
        first |= ( (long) nums[0] << k ) ; 
        rs = Math.max( rs , first ) ; 
        // In Case of The Last one  
        long last = l[n-2] ; 
        last |= ( (long) nums[n-1] << k ) ; 
        rs = Math.max( rs , last ) ; 
        // The middle elements 
        for( int i=1 ; i<n-1 ; ++i ){
            long e = (r[i+1] | l[i-1]) ; 
            e |= ( (long) nums[i] << k ) ; 
            rs = Math.max( rs ,e ) ; 
        }
        return rs ; 
    }
}
