class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length ; 
        int sum = 0 ; 
        for(int i : nums){
            sum += i ; 
        }
        int f = 0 ; 
        int rs = 0 ; 
        for( int i=0 ; i<n-1 ; ++i){
            f += nums[i] ; 
            sum -= nums[i]; 
            if( sum%2==f%2 ){
                ++rs ;
            }
        }
        return rs ;
    }
}