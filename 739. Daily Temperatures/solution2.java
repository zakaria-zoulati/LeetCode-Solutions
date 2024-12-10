class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length ; 
        int[] rs = new int[n] ; 
        int[][] stack = new int[n][2] ; 
        int in = -1 ;  
        stack[++in] = new int[]{ t[n-1] ,n-1 } ; 
        for( int i=n-2 ; i>=0 ; --i ){
            while( in != -1 && t[i] >= stack[in][0] ){
                --in ; 
            } 
            if( in != -1 ){
                rs[i] = stack[in][1] - i ; 
            }
            stack[++in] = new int[]{ t[i] , i } ; 
        }
        return rs ; 
    }
}