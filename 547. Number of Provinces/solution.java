class Solution {
    public int findCircleNum(int[][] g) {
        int n = g.length ; 
        int rs = 0 ;
        boolean[] isSeen = new boolean[n] ; 
        for( int i=0 ; i<n ; ++i ){
            if( !isSeen[i] ){
                rs++ ;
                dfs( g , isSeen , i , n ) ;
            }
        }
        return rs ;  
    }

    public void dfs( int[][] g , boolean[] isSeen , int i , int n ){
        isSeen[i] = true ;
        for( int t=0 ; t<n ; ++t ){
            if( g[i][t] == 1 && !isSeen[t] ){
                dfs( g , isSeen , t , n ) ; 
            }
        }
    }
}