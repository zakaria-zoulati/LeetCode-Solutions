class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length ; 
        long[] right = new long[n] ;
        long rs = Long.MIN_VALUE ; 
        right[n-1] = nums[n-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i+1] > nums[i] ){
                right[i] = Math.max( right[i+1]+nums[i] , nums[i] ) ; 
            }else {
                right[i] = nums[i] ; 
            }
        }
        long curr = nums[0] ; 
        long inter = 0 ; 
        for( int i=1 ; i<=n-3 ; ++i ){
            if( nums[i] > nums[i-1] ){
                if( nums[i+1] >= nums[i] ){
                     curr = Math.max( curr + nums[i] , nums[i] ) ; 
                }
                else{
                    inter = nums[i] ; 
                    while( i+1< n && nums[i+1] < nums[i] ){
                        inter += nums[i+1] ; 
                        i++ ; 
                    }
                    if( i > n-2 ) return rs ; 
                    if( nums[i+1] == nums[i] ){
                        curr = nums[i] ; 
                        i++ ; 
                    }else{
                        rs = Math.max( rs , curr + inter + right[i+1] ) ; 
                        curr = nums[i] ; 
                    }
                }
            }else {
                curr = nums[i] ; 
            }
        }
        return rs  ; 
    }
}