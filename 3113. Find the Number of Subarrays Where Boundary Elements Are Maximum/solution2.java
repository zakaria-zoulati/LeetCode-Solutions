class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length ; 
        long rs = 1L ; ; 
        int[][] s = new int[n][2] ; 
        int in = -1 ; 
        s[++in] = new int[]{nums[0],1}; 
        for( int i=1 ; i<n ; ++i ){
            int[] curr = new int[]{ nums[i] , 1}; 
            while(in != -1 && s[in][0] <= nums[i] ){
                if( s[in][0]  == nums[i] ){
                    curr[1] += s[in][1] ; 
                }
                --in ; 
            }
            s[++in] = curr ; 
            rs += curr[1] ; 
        }
        return rs ;  
    }
}