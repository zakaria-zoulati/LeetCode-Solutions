class Solution {
    public long findScore(int[] nums) {
        int n = nums.length ; 
        long rs = 0;  
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            ( a , b ) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]
        ); 
        boolean[] isMarked = new boolean[n] ;
        for( int i=0 ; i<n ; ++i ){
            pq.add( new int[]{ nums[i] , i } ) ; 
        }
        while( !pq.isEmpty() ){
            int[] curr = pq.poll() ; 
            int ind = curr[1] ;
            if( isMarked[ ind ] ) continue ; 
            int e = curr[0] ; 
            isMarked[ind] = true ; 
            if( ind + 1 < n ) isMarked[ind+1] = true ; 
            if( ind - 1 >= 0 ) isMarked[ind-1] = true ; 
            rs += e ;
        }
        return rs ; 
    }
}