class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isSeen = new boolean[n] ; 
        List<Integer> rs = new ArrayList<>() ; 
        int len = edges.size() ; 
        for(int i=0 ; i<len; ++i ){
            isSeen[ edges.get(i).get(1) ] = true ;
        }

        for(int i=0 ; i<n ; ++i){
            if( !isSeen[i] ){
                rs.add(i) ; 
            }
        }

        return rs ;

    }
}