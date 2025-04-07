class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length ; 
        int sum = 0 ; 
        for( int i : nums ) sum += i ; 
        if( sum % 2 == 1 ) return false ; 
        sum >>= 1 ; 
        boolean[] dp = new boolean[ sum + 1 ] ; 
        dp[0] = true ; 
        for( int i : nums ){
            if( sum - i < 0 ) continue ; 
            if( dp[ sum - i ] ) return true ; 
            for( int j=sum-1 ; j>=i ; --j ){
                if( dp[ j - i ] ){
                    dp[j] = true ; 
                }
            }
        }
        return false ;
    }
}