class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a 
        ); 
        for( int i : stones ){
            pq.add( i ) ; 
        }
        while( pq.size() > 1 ){
            int x = pq.poll() ; 
            int y = pq.poll() ; 
            if( x != y ){
                pq.add( x-y ) ; 
            }
        }
        if( pq.isEmpty() ) return 0 ; 
        return pq.poll() ; 
    }
}