class Solution {
    public int helper( int[] f , int x ){
        int ans = 0 ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                if( a[0] != b[0] ){
                    return b[0] - a[0] ; 
                }
                return b[1] - a[1] ; 
            }
        ); 
        for( int i=1 ; i<=50 ; ++i ){
            if( f[i] > 0 ){
                pq.add( new int[]{ f[i] , i } ) ; 
            }
        }
        while( !pq.isEmpty() && x-- > 0 ){
            int[] curr = pq.poll() ;
            ans += curr[0]*curr[1] ;  
        }
        return ans ; 
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length ;   
        int[] f = new int[51] ; 
        int[] ans = new int[n-k+1] ; 
        for( int i=0 ; i<k ; ++i ) {
            f[ nums[i] ]++ ; 
        }
        ans[0] = helper( f , x ) ; 
        int idx = 1 ; 
        for( int i=k ; i<n ; ++i ){
            f[ nums[i] ]++ ; 
            f[ nums[i-k] ]-- ; 
            ans[ idx++ ] = helper( f , x ) ; 
        }
        return ans ; 
    }
}