class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length ; 
        if( n == 1 ){
            return nums[0] ; 
        }
        Arrays.sort( nums ) ; 
        int pos = 0 ; 
        int zeros = 0 ; 
        long rs = 1L ; 
        for( int i : nums ){
            if( i == 0 ) zeros++ ; 
            else if( i > 0 ) pos++ ; 
        }

        if( pos == 0 ){
            if( zeros >0 &&  (n - zeros) <= 1  ){
                return 0L ; 
            } 
            for( int i=0; i+1<n ; i += 2 ){
                if( nums[i+1] == 0 ) break ; 
                rs *= nums[i] ; 
                rs *= nums[i+1] ; 
            }
            return rs ; 
        }

        for( int i=n-1 ; i>=0 ; --i ){
            if( nums[i] <= 0 ){
                break ;
            }
            rs *= nums[i] ; 
        }

        for( int i=0 ; i<n; i+=2 ){
            if( i+1 >=n || nums[i+1] >=0 ) break ; 
            rs *= nums[i] ; 
            rs *= nums[i+1] ; 
        }
        return rs ; 
    }
}