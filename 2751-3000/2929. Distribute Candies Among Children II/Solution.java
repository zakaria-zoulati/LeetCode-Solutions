class Solution {
    public long distributeCandies(int n, int limit) {
        long rs = 0;  
        int len = Math.min( limit , n ) ; 
        int f = Math.max( 0 , n - 2*limit ) ; 
        for( int i=len ; i>=f ; --i ){
            int re = n - i  ; 
            int end = Math.min(limit , re) ; 
            int start = Math.max( 0 , re - limit ) ; 
            rs += ( end - start + 1 ) ; 
        } 
        return rs; 
    }
}