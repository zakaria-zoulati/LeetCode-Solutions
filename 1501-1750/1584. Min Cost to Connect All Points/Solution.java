import java.util.* ; 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1] 
        );
        List<int[]>[] edges = new ArrayList[n] ; 
        for( int i=0 ; i<n ; ++i ){
            edges[i] = new ArrayList<>() ; 
        }
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                int dist = Math.abs( points[i][0] - points[j][0] ) +
                Math.abs( points[i][1] - points[j][1] ) ;
                edges[i].add( new int[]{ j , dist } ) ;   
                edges[j].add( new int[]{ i , dist } ) ;   
            }
        }   
        int rs = 0 ; 
        boolean[] used = new boolean[n] ; 
        pq.add( new int[]{0,0} ) ; 
        while( !pq.isEmpty() ){
            int[] curr = pq.poll() ; 
            int ele = curr[0] ; 
            int w = curr[1] ; 
            if( used[ele] ) continue ;
            used[ele] = true ; 
            rs += w ; 
            for( int[] next : edges[ele] ){
                if( !used[next[0]] ){
                    pq.add( next ) ; 
                }
            }
        }
        return rs ; 
    }   
}