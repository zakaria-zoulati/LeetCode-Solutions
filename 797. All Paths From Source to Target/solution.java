class Solution {
    public void backtrack(  List<List<Integer>> rs , boolean[] isSeen , int current  , List<Integer> path , int[][] graph , int n  ){
            if(  path.get( path.size() -1  ) == n-1 ){
                isSeen[current] = false ; 
                rs.add( path ) ; 
                return  ; 
            }
            for(int i=0 ; i< graph[current].length ; ++i ){
                if( !isSeen[  graph[current][i]  ] ){
                    isSeen[ graph[current][i] ] = true ; 
                    List<Integer> newPath = new ArrayList<>( path ) ; 
                    newPath.add( graph[current][i] ) ; 
                    backtrack( rs , isSeen , graph[current][i] ,  newPath , graph , n ) ; 
                }
            }
            isSeen[ current ] = false ; 
            return ; 
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length ; 
        List<List<Integer>> rs = new ArrayList<>() ; 
        boolean[] isSeen = new boolean[n] ; 
        List<Integer> path = new ArrayList<>() ; 
        path.add( 0 ) ; 
        isSeen[0] = true ; 
        backtrack( rs , isSeen , 0  , path , graph , n ) ; 
        return rs ; 
    }
}