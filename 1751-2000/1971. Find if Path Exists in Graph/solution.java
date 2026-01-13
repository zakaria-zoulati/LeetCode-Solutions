class Solution {
    public boolean validPath(int n, int[][] edges, int src , int des ) {
        int[] rep = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            rep[i] = i ; 
        }
        for( int[] e : edges ){
            int rep1 = e[0] ; 
            int rep2 = e[1] ; 
            // Find 
            while( rep[rep1] != rep1 ){
                rep1 = rep[rep1] ; 
            }
            while( rep[rep2] != rep2 ){
                rep2 = rep[rep2] ; 
            }
            // Union 
            if( rep1 != rep2 ){
                if( rep1 < rep2 ){
                    rep[rep2] = rep1 ; 
                }else{
                    rep[rep1] = rep2 ; 
                }
            }
        }
        while( rep[src] != src ){
            src = rep[src] ;
        }
        while( rep[des] != des ){
            des = rep[des] ; 
        }
        return src == des ; 
    }
}