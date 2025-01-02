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
        for( int i=1 ; i<n ;++i ){
            if( pref[i] <= k ){
                rs = (i+1) ; 
                while( i+1 < n && nums[i+1] == nums[i] ){
                    rs++ ; 
                    i++ ; 
                }
            }else{
                int j = bs( nums , pref , i , k ) ;
                int curr = i - j ; 
                while( i+1<n && nums[i+1] == nums[i] ){
                    ++i ; 
                    curr++ ;
                }
                rs = Math.max( rs , curr ) ; 
            }
        }
        return rs ; 
    }
    public int bs( int[] nums , long[] pref , int i ,int k ){
        int l = 0 ; 
        int r = i-1 ; 
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            long c = pref[i] - pref[mid] - (long) (mid+1)*( nums[i] - nums[mid] ) ;
            if( c <= k  ){
                r = mid ;
            }else {
                l = mid+1 ;
            }
        }
        return l ; 
    }
}