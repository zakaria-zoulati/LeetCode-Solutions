class Solution {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length ;
        long[] dp = new long[n] ; 
        int curr = 0 ; 
        HashMap<Integer,Long> map = new HashMap<>(); 
        for( int i=0 ; i<n ; ++i ){
            curr = ( curr + nums[i] ) % k ; 
            if( curr == 0 ){
                dp[i] = 0 ; 
            }  
            else if( map.get(curr) != null ){
                dp[i] = Math.min( map.get(curr) , (i>0?dp[i-1]:0) + nums[i] );
            }else {
                dp[i] = (i>0?dp[i-1]:0) + nums[i]  ; 
            }
            map.put(curr,dp[i]) ; 
        }
        return dp[n-1] ; 
    }
}