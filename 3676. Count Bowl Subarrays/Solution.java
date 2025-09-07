class Solution {
    public long bowlSubarrays(int[] heights) {
        int n = heights.length ; 
        int[] rs = new int[n] ; 
        int[] stack = new int[n] ; 
        int in=-1 ; 
        stack[++in] = heights[n-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){ 
            if( heights[i] <= stack[in] ){
                rs[i] = 1 ; 
            }else {
                while( in != -1 && stack[in] <= heights[i] ){
                    --in ; 
                    ++rs[i] ; 
                }
                if( in != -1  ){
                    ++rs[i] ; 
                }
            }
            stack[ ++in ] = heights[i] ; 
        }
        long res = 0 ; 
        for( int i=0 ; i<n-1 ; ++i ){
            res += rs[i]-1;
        } 
        return res ; 
    }
}