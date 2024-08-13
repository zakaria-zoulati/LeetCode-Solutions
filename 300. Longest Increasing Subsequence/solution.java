class Solution {
    public int lengthOfLIS(int[] nums) {
        int dif = (int) 1e4 ;
        int max  = 2*dif +1 ; 
        int n = nums.length ; 
        ArrayList<Integer> arr = new ArrayList<>() ; 
        int rs = 0 ;
        int[] dp = new int[max] ; 
        for(int i=0 ; i<n ; ++i){
            nums[i] += dif ; 
        }
        for(int i=0 ; i<n ; ++i){
            int pos = 0 ; 
            pos = Collections.binarySearch(arr, nums[i] );
            if( !arr.contains( nums[i] )){
                pos = -(pos + 1);  
                if (pos < arr.size()) {
                    arr.set(pos, nums[i] ); 
                } else {
                    arr.add( nums[i] );  
                }
            }
            int current = 0 ; 
            for(int j = pos-1 ; j>=0 ; --j ){
                current = Math.max( dp[  arr.get(j)  ] , current ) ;
            }
            current++ ; 
            dp[nums[i]] = Math.max(  dp[nums[i]] , current ) ; 
            rs = Math.max( rs , dp[nums[i]] ) ; 
        }
        return rs ; 
    }
}