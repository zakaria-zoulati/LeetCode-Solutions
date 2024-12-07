class Solution {
    public int minimumSize(int[] nums, int ops) {
        int n = nums.length ; 
        int l = 1 ; 
        int r = -1 ; 
        for( int i:nums ){
            r = Math.max( r , i ) ; 
        }
        while( l < r ){
            int mid=l+(r-l)/2 ; 
            if(isValid(nums , mid , ops)){
                r = mid ; 
            }else {
                l = mid + 1 ; 
            }
        }
        return l ;
    }
    public boolean isValid( int[] nums , int mid , int ops ){
        for( int i=nums.length - 1 ; i>=0  ; --i ){ 
            ops -= ( nums[i] + mid-1 )/mid -1  ; 
            if( ops <0 ) return false ; 
        }
        return true ;  
    }
}