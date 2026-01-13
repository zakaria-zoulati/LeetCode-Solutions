class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ; 
        int[] rep = new int[n+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            rep[i] = i ; 
        }
        for( int[] e : edges ){
            if( !merge( rep , e[0] , e[1] ) ){
                return new int[]{e[0] , e[1] } ; 
            }
        }
        return new int[2] ;
    }
    public boolean merge( int[] rep , int a , int b ){
        while( rep[a] != a ){
            a = rep[a] ; 
        } 
        while( rep[b] != b ){
            b = rep[b] ;
        }
        if( a == b ) return false ; 
        if( a < b ){
            rep[b] = a ;
        }else {
            rep[a] = b ; 
        }
        return true ; 
    }
}