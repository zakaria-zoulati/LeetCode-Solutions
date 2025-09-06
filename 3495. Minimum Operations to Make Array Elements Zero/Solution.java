class Solution {
    long[] memo = new long[16] ; 
    long[] pows = new long[17] ; 
    long helper( int l ){
        if( l < 4 ){
            return l ; 
        }
        long temp = l ; 
        int s = 0 ;
        while( temp > 0 ){
            s++ ; 
            temp >>= 2 ;
        }
        long rs = (long) (( l - pows[s-1] + 1 )*s) + memo[s-2] ; 
        return rs;  
    }  
    public long minOperations(int[][] queries) {
        pows[0] = 1 ; 
        for( int i=1 ; i<=16 ; ++i ){
            pows[i] = pows[i-1]*4 ; 
        }
        memo[0] = 3 ;    
        for( int i=1 ; i<=15 ; ++i ){
            long curr = (long) ( pows[i+1]-1 - pows[i] + 1 )*(i+1) ; 
            memo[i] = memo[i-1] + curr ; 
        }
        long rs = 0 ; 
        for( int[] q : queries ){
            int l = q[0] ; 
            int r = q[1] ; 
            long curr = helper(r) - helper(l-1)+1 ; 
            rs += curr>>1 ; 
        }
        return rs ; 
    }
}