class Solution {
    public int minimizeMax(int[] nums, int p) {
        if( p == 0 ) return 0 ; 
        int n = nums.length ; 
        Arrays.sort( nums ) ; 
        int rs = 0 ;
        int l = 0 ;
        int r = nums[n-1] - nums[0] ; 
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            int count = 0 ; 
            for( int i=0;i+1<n ;++i ){
                if( nums[i+1] - nums[i] <= mid ){
                    count++ ;
                    i++ ; 
                }
            }
            if( count >= p ){
                r = mid ; 
            }else {
                l = mid + 1 ; 
            }
        }
        return l ; 
    }
}