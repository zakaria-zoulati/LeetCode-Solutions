class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int m = queries.length ; 
        int[] rs = new int[m] ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a ) ; 
        for(int i=0 ; i<m ; ++i){
            if( i+1 < k  ){
                rs[i] = -1 ; 
                pq.add(  Math.abs( queries[i][0] ) + Math.abs( queries[i][1] )  ) ; 
            }else {
                if( i+1==k ){
                    pq.add(  Math.abs( queries[i][0] ) + Math.abs( queries[i][1] )  ) ; 
                    rs[i] = pq.peek() ; 
                }else {
                    int d =  Math.abs( queries[i][0] ) + Math.abs( queries[i][1] ) ; 
                    pq.add( d ) ; 
                    pq.poll()  ;
                    rs[i] = pq.peek() ; 
                }
            }
        }

        return rs; 


    }
}