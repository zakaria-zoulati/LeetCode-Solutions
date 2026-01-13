class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length ; 
        long rs = 0L ;
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                for( int k=j+1 ; k<n ; ++k ){
                    long curr = ( long ) ( nums[i] - nums[j] ) * nums[k] ; 
                    rs = Math.max( rs , curr ) ; 
                }
            }
        }

        return rs ; 
    }
}