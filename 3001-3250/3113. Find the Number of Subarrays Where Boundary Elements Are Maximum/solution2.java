class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length ; 
        long rs = 0L ; ; 
        int[][] s = new int[n][2] ; 
        int in = -1 ; 
        for( int i : nums){
            int[] curr = new int[]{i , 1}; 
            while( in != -1 && s[in][0] < i ){
               --in ;  
            }
            if( in == -1 || s[in][0] > i ){
                s[++in] = curr ; 
            }else {
                s[in][1]++ ; 
            }
            rs += s[in][1] ; 
        }
        return rs ;  
    }
}