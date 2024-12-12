class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a 
        ); 
        for( int i : gifts ){
            pq.add(i);
        }
        while( k-- > 0 ){
            int cu = pq.poll() ; 
            cu = (int) Math.sqrt(cu) ; 
            pq.add(cu) ; 
        }
        long rs = 0L ; 
        while( !pq.isEmpty() ){
            rs += pq.poll() ; 
        }
        return rs ; 
    }
}