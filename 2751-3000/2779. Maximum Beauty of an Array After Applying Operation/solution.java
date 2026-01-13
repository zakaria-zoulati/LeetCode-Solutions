class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length ; 
        int max = 0 ; 
        for( int i : nums ){
            if( i>max ) max=i ; 
        }
        int[] pref = new int[max+1] ; 
        int rs = 1 ; 
        for( int i : nums ){
            ++pref[i] ; 
        }
        for(int i=1 ; i<=max ; ++i ){
            pref[i] += pref[i-1] ; 
        }
        for( int i=0 ; i<=max ; ++i ){
            int curr = pref[i] - ( i>k ? pref[i-k-1] : 0  ) + ( pref[ ( i+k <=max ? i+k : max )] - pref[i] ) ;
            rs = Math.max( curr , rs ); 
        }
        return rs ; 
    }
}