class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int rs = -1; 
        int best = 0;  
        for( int[] rec : dimensions ){
            int curr = rec[0]*rec[0] + rec[1]*rec[1] ; 
            if( curr > best ){
                best = curr ; 
                rs = rec[0]*rec[1] ; 
            }else if( curr == best ){
                rs = Math.max( rs , rec[0]*rec[1] ) ; 
            }
        }
        return rs; 
    }
}