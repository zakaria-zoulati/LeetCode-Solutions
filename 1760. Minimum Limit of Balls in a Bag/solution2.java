class Solution {
    public int minimumSize(int[] nums, int ops) {
        Arrays.sort( nums ) ; 
        int n = nums.length ; 
        int left = 1 ; 
        int right = nums[n-1] ; 
        while( left < right ){
            int mid = left + ( right - left )/2 ; 
            if( isValid( nums , mid , ops ) ){
                right = mid ; 
            }else {
                left = mid + 1 ; 
            }
        }
        return left ;
    }

    public boolean isValid( int[] nums , int mid , int ops ){
        int curr = 0 ; 
        for( int i=nums.length - 1 ; i>=0 && curr<=ops ; --i ){
            if( nums[i] <= mid ) break ; 
            curr +=  (  nums[i] + mid-1 )/mid -1  ; 
        }
        return curr<=ops ; 
    }
}