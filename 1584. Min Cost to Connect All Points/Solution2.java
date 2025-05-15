import java.util.* ; 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ; 
        int rs = 0 ;
        int[] dist = new int[n] ; 
        Arrays.fill( dist , Integer.MAX_VALUE ) ; 
        dist[0] = 0 ; 
        boolean[] used = new boolean[n] ; 
        for( int i=0 ; i<n ; ++i ){
            int u = -1 ; 
            for( int j=0 ; j<n ; ++j ){
                if( !used[j] & ( u == -1 || dist[j] < dist[u] ) ){
                    u = j ; 
                }
            }
            used[u] = true ; 
            rs += dist[u] ; 
            for( int j=0 ; j<n ; ++j ){
                if( !used[j] ){
                    int d = Math.abs( points[j][0] - points[u][0] ) + Math.abs( points[j][1] - points[u][1] ) ;  
                    if( d < dist[j] ){
                        dist[j] = d ; 
                    }
                }
            }
        }
        return rs ;
    }   
}