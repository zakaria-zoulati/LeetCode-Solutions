class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a
        );
        for(int[] r : matrix){
            for( int e : r ){
                if( pq.size() < k ){
                    pq.add( e ) ; 
                }else if( pq.peek() > e ){
                    pq.poll() ; 
                    pq.add( e )  ;
                }
            }
        }
        return pq.poll() ; 
    }
}