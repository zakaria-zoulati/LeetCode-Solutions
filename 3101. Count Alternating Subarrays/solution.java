class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long rs = 0 ; 
        int n = nums.length ; 
        long curr = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            curr++ ; 
            while( i+1<n && (nums[i] ^ nums[i+1] ) == 1  ){
                curr++  ;
                i++ ;
                
            }
            rs += curr*(curr+1)/2 ;
            curr = 0 ;
        }
        return rs ;
    }
}