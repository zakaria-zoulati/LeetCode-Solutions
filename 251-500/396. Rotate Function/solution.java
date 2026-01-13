class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length ; 
        int sum = 0 ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            sum += nums[i] ; 
            rs += i*nums[i] ; 
        }
        int curr = rs ; 
        for(int i=1 ;i<n ; ++i){
            curr = curr + sum -n*nums[n-i] ; 
            rs = Math.max( rs , curr ) ;  
        }
        return rs  ;


    }
}