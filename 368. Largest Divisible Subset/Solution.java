class Solution {
    public void fill( List<Integer> rs , int[] nums , int[] dp , int tar ){
        int n = nums.length ; 
        int i = 0 ;
        while( dp[i] != tar ) ++i ;  
        int curr = nums[i++] ; 
        rs.add( curr ) ; 
        tar-- ; 
        for(  ; i<n ; ++i ){
            if( dp[i] == tar && nums[i] % curr == 0 ){
                curr = nums[i] ; 
                rs.add( curr ) ; 
                tar-- ; 
            }
        }
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length ; 
        List<Integer> rs = new ArrayList<>() ; 
        Arrays.sort( nums ) ; 
        int[] dp = new int[n] ; 
        Arrays.fill( dp , 1 ) ; 
        int tar = 0 ;
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=i+1 ; j<n ; ++j ){
                if( nums[j] % nums[i] == 0 ){
                    dp[i] = Math.max( dp[i] , dp[j] + 1 ) ; 
                }
            }
            tar = Math.max( tar , dp[i] ) ; 
        }

        fill( rs , nums ,  dp , tar ) ; 
        return rs ; 
    }
}