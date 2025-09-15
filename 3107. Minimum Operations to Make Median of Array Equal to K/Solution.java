import java.util.* ; 
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length ; 
        Arrays.sort( nums ) ; 
        int mid = nums[n/2] ; 
        if( mid <= k ){
            long rs = 0 ; 
            for( int i=n/2 ; i<n ; ++i ){
                if( nums[i] < k ){
                    rs += k - nums[i] ; 
                }
            }
            return rs ; 
        }else {
            long rs = 0 ; 
            for( int i=n/2 ; i>=0 ; --i ){
                if( nums[i] > k ){
                    rs += nums[i] - k ; 
                }
            }
            return rs ;
        }
    }
}