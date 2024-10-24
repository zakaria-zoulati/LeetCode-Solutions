class Solution {
    public int minProcessingTime(List<Integer> p , List<Integer> t ) {
        int n = p.size() ;
        Collections.sort( p ) ; 
        PriorityQueue< Integer > q = new PriorityQueue<>(
            (a,b) -> b - a
        ); 
        int rs = 0 ; 
        for(Integer i : t){
            q.add(i) ; 
        }
        while( q.size() > 0 ){
            int curr = 0 ; 
            for( int i=0; i<4 ; ++i ){
                curr = Math.max( curr , q.poll() + p.get(0) ) ; 
            }
            rs = Math.max( rs , curr ) ; 
            p.remove(0) ; 
        }
        return rs ; 
    }
}