class Solution {
    public long minimumDifference(int[] nums) {
        int len = nums.length ; 
        int n = len/3 ; 
        long[] min = new long[n+1] ;
        long[] max = new long[n+1] ; 
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(
            (a,b) -> b-a 
        ) ; 
        long curr = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            pq1.add( nums[i] ) ; 
            curr += nums[i] ; 
        }
        min[0] = curr ; 
        int idx = 1 ;
        for( int i=n ; i<2*n ; ++i ){
            if( pq1.peek() > nums[i] ){
                pq1.add( nums[i] ) ; 
                curr += ( nums[i] -  pq1.poll()) ; 
            }
            min[idx] = Math.min( min[idx-1] , curr) ; 
            idx++; 
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); 
        curr = 0 ; 
        for( int i=len-1 ; i>=len-n ; --i){
            pq2.add( nums[i] ) ; 
            curr += nums[i] ; 
        }
        max[0] = curr ; 
        idx = 1 ; 
        for( int i=len-n-1 ; i>=n ; --i ){
            if( pq2.peek() < nums[i] ){
                pq2.add( nums[i] ) ; 
                curr += ( nums[i] -  pq2.poll()) ; 
            }
            max[idx] = Math.max( max[idx-1] , curr) ; 
            idx++ ; 
        }
        long rs = Long.MAX_VALUE ; 
        for( int i=0 ; i<=n ; ++i ){
            rs = Math.min( rs , min[i] - max[n-i]  ) ; 
        }
        return rs ;
    }
}