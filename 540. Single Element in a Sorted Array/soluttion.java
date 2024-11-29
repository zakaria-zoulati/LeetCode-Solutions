class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length  ; 
        int left = 0 ; 
        int right = n-1 ; 
        while( left < right ){
            int mid = left + (right-left)/2 ; 
            if( mid % 2 == 0  ){
                ++mid ; 
            }
            if( arr[mid] == arr[mid-1] ){
                left = mid+1 ;
            }else {
                right = mid-1 ; 
            }
        }
        return arr[right] ; 
    }
}