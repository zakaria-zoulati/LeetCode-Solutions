class Solution {
    public int maximumCount(int[] nums) {
        int l = 0 ; 
        int r = nums.length - 1 ; 
        while( l <= r ){
            int mid = l + ( r - l )/2 ; 
            if( nums[mid] >= 0 ){
                r = mid-1 ; 
            }else {
                l = mid+1 ; 
            }
        }
        int n = l  ; 
        l = 0 ; 
        r = nums.length - 1 ; 
        while( l <= r ){
            int mid = l + ( r - l )/2 ; 
            if( nums[mid] > 0 ){
                r = mid - 1 ; 
            }else {
                l = mid + 1 ; 
            }
        }
        int p = nums.length - l  ; 
        return Math.max( p , n ) ; 
    }
}