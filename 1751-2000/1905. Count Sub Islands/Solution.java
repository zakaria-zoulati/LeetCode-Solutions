class Solution {
    int n , m ; 
    void trav( int[][] g2 , int i , int j ){
        g2[i][j] = 0 ; 
        int t = i+1 ; 
        if( t < n && g2[t][j] == 1 ){
            trav( g2 , t , j ) ; 
        }
        t = j+1 ; 
        if( t < m && g2[i][t] == 1 ){
            trav( g2 , i , t ) ; 
        }
        t = i-1 ; 
        if( t >= 0 && g2[t][j] == 1 ){
            trav( g2 , t , j ) ; 
        }
        t = j-1 ; 
        if( t >=0 && g2[i][t] == 1 ){
            trav( g2 , i , t ) ; 
        }
    }
    boolean dfs( int[][] g1 , int[][] g2  , int i , int j ){
        g2[i][j] = 0 ; 
        int t = i+1 ; 
        boolean rs = true ; 
        if( t < n && g2[t][j] == 1 ){
            if( g1[t][j] == 0 ){
                rs = false ; 
                trav( g2 , t ,j ) ; 
            }else {
                 rs &= dfs( g1 , g2 , t , j ) ; 
            }
        }
        t = j+1 ; 
        if( t < m && g2[i][t] == 1 ){
            if( !rs || g1[i][t] == 0 ){
                rs = false ; 
                trav( g2 , i ,t  ) ; 
            }else {
                rs &= dfs( g1 , g2 , i ,t ) ; 
            }
        }
        t = i-1 ; 
        if( t >= 0 && g2[t][j] == 1 ){
            if( !rs || g1[t][j] == 0 ){
                rs = false ; 
                trav( g2 , t , j ) ; 
            }else {
                rs &= dfs( g1 , g2 , t ,j ) ; 
            }
        }
        t = j-1 ; 
        if( t >=0 && g2[i][t] == 1 ){
            if( !rs || g1[i][t] == 0 ){
                rs = false ; 
                trav( g2 , i ,t  ) ; 
            }else {
                rs &= dfs( g1 , g2 , i ,t ) ; 
            }
        }
        return rs ; 
    }
    public int countSubIslands(int[][] g1, int[][] g2) {
        this.n = g1.length ; 
        this.m = g1[0].length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( g2[i][j] == 1 && g1[i][j] == 1 ){
                    if( dfs( g1 , g2 , i , j ) ){
                        rs++ ; 
                    }
                }
            }
        } 
        return rs ; 
    }
}