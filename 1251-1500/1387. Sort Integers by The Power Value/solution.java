class Solution {
    int[] dp = new int[1_001] ; 
    int curr = 2 ; 
    public int getVal( int n ){
        int next = n%2 == 0 ? n/2 : 3*n + 1 ; 
        if( next < curr ){
            return 1 + dp[next] ; 
        }else {
            return 1 + getVal( next ) ; 
        }
    }
    public int getKth(int lo, int hi, int k) {
        for(   ; curr < 1_001 ; ++curr ){
            dp[ curr ] = getVal( curr ) ; 
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            ( a , b ) -> dp[a] - dp[b] == 0 ? b-a : dp[b] - dp[a]
        ); 
        for( int i=lo ; i<=hi ; ++i ){
            pq.add(i) ; 
        }
        while( pq.size() > k ){
            pq.poll() ;
        }
        return pq.poll() ;  
    }
}