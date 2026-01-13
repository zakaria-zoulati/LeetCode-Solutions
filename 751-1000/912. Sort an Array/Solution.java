class Solution {
    int[] temp ; 
    void mergeSort( int[] nums , int l , int r ){
        if( l == r ) return ; 
        int mid = l + ( r - l )/2 ; 
        mergeSort( nums , l , mid ) ; 
        mergeSort( nums , mid+1 , r ) ; 
        int a = l , b = mid+1 ; 
        for(int i=l ; i<=r ; ++i){
            if( a > mid ){
                temp[i] = nums[b++] ; 
            }else if( b > r ){
                temp[i] = nums[a++] ;   
            }else if( nums[a] <= nums[b] ) {
                temp[i] = nums[a++] ; 
            }else {
                temp[i] = nums[b++] ; 
            }
        }
        for( int i=l ; i<=r ; ++i ){
            nums[i] = temp[i] ; 
        }
    }
    public int[] sortArray(int[] nums) { 
        this.temp = new int[nums.length] ; 
        mergeSort( nums , 0  , nums.length - 1 ) ; 
        return nums ;
    }
}