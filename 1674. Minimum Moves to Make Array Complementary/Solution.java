class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length ; 
        int m = Integer.MIN_VALUE ; 
        int t = n/2 ; 
        int curr ;
        for( int i=0 ; i<t ; ++i ){
            curr = nums[i]+nums[n-1-i] ; 
            if( curr > m ) m=curr ;
        }
        int[] diff = new int[m+2] ; 
        int a , b ; 
        for( int i=0 ; i<t ; ++i ){
            a = nums[i]<=nums[n-1-i]?nums[i]:nums[n-1-i] ;
            curr = nums[i]+nums[n-1-i]  ;
            b = curr-a ; 
            diff[2] += 2 ; 
            diff[1+a] -= 1 ; 
            diff[curr] -= 1 ; 
            diff[curr+1] += 1 ; 
            if( b+limit+1 <= m ){
                diff[b+limit+1] += 1 ; 
            }
        }
        int rs = diff[2] ; 
        for( int i=2 ; i<=m ; ++i ){
            if( (diff[i] += diff[i-1]) < rs ) rs = diff[i] ; 
        }
        return rs ; 
    }
}