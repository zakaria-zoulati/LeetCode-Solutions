class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length ; 
        int ans = Integer.MAX_VALUE ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                if( nums[i] == nums[j] ){
                    for( int k=j+1 ; k<n ; ++k ){
                        if( nums[k] == nums[j] ){
                            ans = Math.min( ans , (k-i) << 1 ) ;
                            break ; 
                        }
                    }
                    break ;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans ; 
    }
}