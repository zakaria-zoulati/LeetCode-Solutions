class Solution {
    public void swap( int[] nums , int i , int j ){
        int temp = nums[i] ; 
        nums[i]  = nums[j] ; 
        nums[j]  = temp ; 
    }
    public void reverse( int[] nums , int i , int j ){
        while( i < j ){
            swap( nums , i , j ) ; 
            i++ ; 
            j-- ; 
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length ; 
        int i = n-2 ; 
        for( ; i>=0 ; --i ){
            if( nums[i] < nums[i+1] ){
                break ; 
            }
        }
        if( i >= 0 ){
            int l = i+1 ; 
            int r = n-1 ; 
            while( l < r ){
                int mid = l + ( r - l + 1 )/2 ; 
                if( nums[mid] > nums[i] ){
                    l = mid ; 
                }else {
                    r = mid - 1; 
                }
            }
            swap( nums , i , l ) ;  
        }
        reverse( nums , i+1 , n-1 ) ;  
    }
}