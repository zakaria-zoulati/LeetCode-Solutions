class Solution {
    public int minimumArrayLength(int[] nums) {
        int n = nums.length ; 
        int min = Integer.MAX_VALUE ; 
        int count = 0 ; 
        int g = nums[0] ; 
        for( int i : nums ){
            if( i < min ){
                min = i ; 
                count = 1 ; 
            }else if( i == min ){
                count++ ; 
            }
        }
        for( int i : nums ){
            if( i % min != 0 ){
                return 1 ; 
            }
        }
        int rs = count/2 + count%2 ; 
        return rs ;
    }
}