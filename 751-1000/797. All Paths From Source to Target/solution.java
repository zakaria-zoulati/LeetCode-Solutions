class Solution {
    public void backtrack(  List<List<Integer>> rs , boolean[] isSeen , int current  , List<Integer> path , int[][] graph , int n  ){
            if(  path.get( path.size() -1  ) == n-1 ){
                isSeen[current] = false ; 
                rs.add( new ArrayList<>(path) ) ; 
                return  ; 
            }
            for(int item: graph[current] ){
                if( !isSeen[ item ] ){
                    isSeen[ item ] = true ; 
                    path.add(item) ;
                    backtrack( rs , isSeen , item ,  path , graph , n ) ; 
                    path.remove(  path.size() -1 ) ; 
                    isSeen[item] = false; 
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