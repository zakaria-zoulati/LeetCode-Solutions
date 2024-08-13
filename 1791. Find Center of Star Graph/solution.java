class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length ; 
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        for(int i=0 ; i<2 ; ++i){
            map.put( edges[i][0] , map.getOrDefault( edges[i][0] , 0 ) +1 ) ; 
            map.put( edges[i][1] , map.getOrDefault( edges[i][1] , 0 ) +1 ) ; 
        }

        for( Integer a : map.keySet() ){
            if( map.get( a ) == 2  ){
                return a  ; 
            }
        }
        return -1 ; 
    }
}