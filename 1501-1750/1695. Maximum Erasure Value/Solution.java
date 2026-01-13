class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length ; 
        int els = 0 ; 
        int curr = 0 ; 
        int start = 0  ;
        int len = 0 ; 
        int rs = nums[0] ; 
        int[] f = new int[10_001] ; 
        for( int i=0 ; i<n ; ++i ){
            len++ ; 
            curr += nums[i] ; 
            if( f[nums[i]]++ == 0 ){
                els++ ; 
                if( curr > rs ) rs = curr ; 
            }else {
                while( els < len ){
                    len-- ; 
                    curr -= nums[start] ; 
                    if( f[ nums[start++] ]-- == 1 ){
                        els-- ; 
                    }
                }
            }
        }
        return rs ; 
    }
}