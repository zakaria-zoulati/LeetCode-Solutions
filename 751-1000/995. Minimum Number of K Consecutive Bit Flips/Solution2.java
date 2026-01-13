class Solution {
    public int minKBitFlips(int[] nums, int k) {
        if( k == 1 ){
            int ans = nums.length ; 
            for( int num : nums ) ans -= num ; 
            return ans ; 
        }
        int n = nums.length ; 
        boolean[] flipped = new boolean[n] ; 
        int ans = 0; 
        int prev = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( i>=k ){
                if( flipped[i-k] ) prev-- ; 
            }
            if( (prev&1) == nums[i] ){
                if( i + k > n ) return -1 ; 
                prev++ ; 
                flipped[i] = true ; 
                ans++ ; 
            }
        }
        return ans ; 
    }
}