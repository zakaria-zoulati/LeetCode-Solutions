class Solution {
    public int minCost(int n, int[][] edges) {
        int m = edges.length ;
        List<int[]>[] edd = new ArrayList[n] ;
        for( int i=0 ; i<n ; ++i ){
            edd[i] = new ArrayList<>() ; 
        }
        for( int[] e : edges ){
            int a = e[0] ; 
            int b = e[1] ; 
            int c = e[2] ; 
            edd[a].add( new int[]{ b , c } );
            edd[b].add( new int[]{ a ,2*c } );
        }
        int[] dist = new int[n] ; 
        Arrays.fill( dist , Integer.MAX_VALUE ) ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        ); 
        pq.add( new int[]{0,0} ) ; 
        while( !pq.isEmpty() ){
             int[] curr = pq.poll() ; 
             int d = curr[0] ; 
             int u = curr[1] ; 
             if( d >= dist[u] ) continue ; 
             dist[u] = d ; 
             for( int[] e : edd[u] ){
                 pq.add( new int[]{ d + e[1] , e[0] } )  ; 
             }
        }
        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1] ; 
    }
}