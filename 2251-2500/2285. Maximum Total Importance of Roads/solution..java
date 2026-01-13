class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long rs = 0L ; 
        int[] f = new int[n] ; 
        for( int[] r : roads ){
            f[ r[0] ]++ ; 
            f[ r[1] ]++ ; 
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a
        );
        for(int i : f ){
            if( i != 0 ){
                pq.add(i) ; 
            }
        } 
        while( !pq.isEmpty() ){
            rs += (long) pq.poll()*n-- ; 
        }

        return rs ;
    }
}