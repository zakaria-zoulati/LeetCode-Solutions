class Solution {
    public boolean dfs( int[] isVisited , ArrayList<Integer>[] edges , int in ){
        if( isVisited[in] == 1 ) return false ;
        if( isVisited[in] == 2 ) return true ; 
        isVisited[in] = 1 ; 
        for( int i : edges[in] ){
            if( !dfs( isVisited , edges , i ) ){
                return false ; 
            }
        }
        isVisited[in] = 2 ; 
        return true ; 
    }
    public void dfs_build( int[] isVisited , ArrayList<Integer>[] edges , int[] rs , int curr , int[] in ){
        if( isVisited[ curr ] == 2 ) return ; 
        for( int i : edges[curr] ){
            dfs_build( isVisited , edges , rs , i , in ) ; 
        }
        isVisited[curr] = 2 ; 
        rs[ in[0]-- ] =  curr ; 
    }
    public int[] findOrder(int n , int[][] pr ) {
        ArrayList<Integer>[] edges = new ArrayList[n] ; 
        for( int i=0 ; i<n ; ++i ){
            edges[i] = new ArrayList<>() ; 
        }
        for( int[] i : pr ){
            edges[ i[1] ].add( i[0] ) ; 
        }
        int[] isVisited = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            if( isVisited[i] == 0 ){
                if( !dfs( isVisited , edges , i ) ){
                    return new int[0] ; 
                }
            }
        }
        Arrays.fill( isVisited , 0 ) ; 
        int[] rs = new int[n] ; 
        int[] in = {n-1} ; 
        for( int i=0 ; i<n ; ++i ){
            if( isVisited[i] == 0 ){
                dfs_build( isVisited , edges , rs , i ,  in ) ; 
            }
        }
        return rs ; 
    }
}