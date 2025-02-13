class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> a - b
        ) ; 
        for( int i : nums ){
            if( i< k ){
                pq.add( i ) ; 
            } 
        }
        int rs = 0 ; 
        while( pq.size() >= 2 ){
            ++rs ; 
            long val = (long) 2*pq.poll() + pq.poll() ;  
            if( val < k ){
                pq.add( (int) val ) ; 
            }
        }
        rs += pq.size() ; 
        return rs ; 
    }
}