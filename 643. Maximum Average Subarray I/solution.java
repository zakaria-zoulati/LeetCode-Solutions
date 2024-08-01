class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length ; 
        double rs = 0 ; 
        double inter = 0 ; 
        for(int i=0 ; i<k ; i++){
            rs += nums[i] ; 
        }
        inter = rs ; 
        for(int i=1 ; i+k-1<n ; i++ ){
            inter -= nums[i-1] ; 
            inter += nums[i+k-1] ; 
            rs=Math.max(inter,rs) ;  
        }
        return rs/k ; 
    }
}