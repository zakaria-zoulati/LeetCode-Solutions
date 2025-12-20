class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length ; 
        long ans = 0 ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a ) ; 
        for( int i=0 ; i<n ; ++i ){
            pq.add( nums[i] ) ; 
            if( s.charAt(i) == '1' ){
                ans += pq.poll() ; 
            }
        }
        return ans ; 
    }
}