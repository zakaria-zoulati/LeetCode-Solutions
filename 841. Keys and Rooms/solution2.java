class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size() ; 
        boolean[] isVisited = new boolean[n] ;    
        Queue<Integer> q = new LinkedList<>() ; 
        q.add(0) ; 
        int count = 0 ; 
        while( !q.isEmpty() ){
            int k = q.poll() ; 
            if( !isVisited[k] ){
                ++count ; 
                isVisited[k] = true ; 
                for( int i=0 ; i<rooms.get(k).size() ; ++i ){
                    if( !isVisited[ rooms.get(k).get(i)] ){
                        q.add( rooms.get(k).get(i)) ; 
                    }
                }
            }
        }
        return count == n ; 
    }
}