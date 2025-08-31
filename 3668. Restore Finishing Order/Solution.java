class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length ; 
        int m = friends.length ; 
        int[] rs = new int[m] ; 
        boolean[] f = new boolean[n+1] ; 
        for( int i : friends ) f[i] = true ; 
        int in = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( f[order[i]] ){
                rs[in++] = order[i] ;  
            }
        }
        return rs ; 
    }
}