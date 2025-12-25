class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length ; 
        Arrays.sort( happiness ) ; 
        long ans = 0 ; 
        int rem = 0 ; 
        for( int i=n-k ; i<n ; ++i ){
            if( happiness[i] <= 0 ) return ans ; 
            if( happiness[i] - rem >= ( n - 1 -i ) ){
                ans += happiness[i] - rem ; 
                rem++ ; 
            } 
        }
        return ans ; 
    }
}