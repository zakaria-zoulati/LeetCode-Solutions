class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length ; 
        int[] f = new int[100_001] ; 
        int d = 0;  
        for( int num : nums ){
            if( ++f[num] == 2 ) d++ ; 
        }
        int ans = 0 ;
        int i = 0 ; 
        while( d>0 ){
            ans++ ; 
            if( n-1 - i + 1 >= 3 ){
                if( f[nums[i++]]-- == 2 ) d-- ; 
                if( f[nums[i++]]-- == 2  ) d-- ; 
                if( f[nums[i++]]-- == 2 ) d-- ; 
            }else {
                d = 0  ; 
            }
        }
    
        return ans ; 
    }
}