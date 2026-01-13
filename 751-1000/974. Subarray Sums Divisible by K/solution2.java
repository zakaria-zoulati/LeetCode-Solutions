class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length ; 
        int[] freq = new int[k] ; 
        int rs = 0 ;
        nums[0] = ( 10000*k + nums[0] ) % k  ; 
        if( nums[0]  == 0  ){
            rs++ ; 
        }
        freq[0]++ ; 
        freq[ nums[0] ]++ ; 
        for(int i=1 ; i<n ; ++i){
            nums[i] = ( nums[i] + nums[i-1] + 10000*k ) % k ; 
            rs += freq[ nums[i] ] ; 
            freq[ nums[i] ]++ ; 
        }
        return rs ; 
    }
}