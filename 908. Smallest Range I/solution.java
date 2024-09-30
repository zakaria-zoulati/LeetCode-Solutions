class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = 0 ; 
        int min = Integer.MAX_VALUE ; 
        for(int num : nums ){
            if( num > max ){
                max = num ; 
            }
            if( num < min ){
                min = num ; 
            }
        }
        if( max - min <= 2*k ){
            return 0 ; 
        }
        return max - min - 2*k ; 
    }
}