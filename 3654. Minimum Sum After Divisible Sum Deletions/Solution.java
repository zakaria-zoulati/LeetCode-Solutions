class Solution {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length ; 
        long sum = 0 ; 
        for(int i: nums){
            sum += i ; 
        }
        long[] dp = new long[n] ; 
        int curr = 0 ; 
        HashMap<Integer,Long> map = new HashMap<>(); 
        for( int i=0 ; i<n ; ++i ){
            curr = ( curr + nums[i] ) % k ; 
            dp[i] = Long.MAX_VALUE ; 
            if( curr == 0 ){
                dp[i] = 0 ; 
            }  
            else if( map.get(curr) != null ){
                dp[i] = map.get(curr) ; 
            }
            dp[i] = Math.min( dp[i] , (i>0?dp[i-1]:0) + nums[i] ) ; 
            if( map.get(curr) == null || map.get(curr) > dp[i] ){
                map.put(curr,dp[i]) ; 
            }
        }
        return dp[n-1] ; 
    }
}