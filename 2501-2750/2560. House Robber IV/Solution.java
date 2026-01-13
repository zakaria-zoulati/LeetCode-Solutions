class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length ; 
        int l = Integer.MAX_VALUE ; 
        int r = -1 ; 
        for( int i : nums ){
            r = Math.max( r , i ) ; 
            l = Math.min( l , i ) ; 
        }
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            int count = 0  ; 
            for( int i=0 ; i<n ; ++i ){
                if( nums[i] <= mid ){
                    i++ ; 
                    count++ ;
                }
            }
            if(  count >= k ){
                r = mid ; 
            }else {
                l = mid+1 ; 
            }
        }   
        return l ; 
    }
}