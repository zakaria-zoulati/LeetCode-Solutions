class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> ( Math.abs( a - x ) - Math.abs( b-x ) == 0 ? a - b : Math.abs( a-x ) - Math.abs( b-x )  )
        ) ; 
        List<Integer> list = new ArrayList<>() ; 
        for(int num : arr ){
            pq.add( num ) ; 
        }
        while( k-- > 0 ){
            list.add( pq.poll() ) ; 
        }
        Collections.sort( list ) ; 
        return list ; 
    }
}