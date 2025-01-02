class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length ; 
        Arrays.sort( nums ) ; 
        long[] pref = new long[n] ; 
        pref[0] = 0 ; 
        int max = nums[0] ; 
        int ele = 1 ;
        for( int i=1 ; i<n ; ++i ){
            pref[i] = pref[i-1] + (long) ele*( nums[i] - max ) ; 
            ele++ ; 
            max = nums[i] ; 
        }
        int rs = 1 ; 
        int left = 0 ; 
        for( int i=1 ; i<n ;++i ){
            if( pref[i] <= k ){
                rs = (i+1) ; 
                while( i+1 < n && nums[i+1] == nums[i] ){
                    ++rs ; 
                    ++i ; 
                }
            }else{
                long cost = pref[i] - pref[left] - (long) (left+1)*( nums[i] - nums[left] ) ;
                while( cost > k ){
                    left++ ; 
                    cost = pref[i] - pref[left] - (long) (left+1)*( nums[i] - nums[left] ) ; 
                }
                int curr = i - left ; 
                while( i+1 < n && nums[i+1] == nums[i] ){
                    ++i ; 
                    curr++ ; 
                }
                rs = Math.max( curr , rs ) ; 
            }
        }
        return rs ; 
    }
}