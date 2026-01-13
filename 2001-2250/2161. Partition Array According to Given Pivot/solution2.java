class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        int right = n-1 ; 
        int left = 0 ; 
        for(int i=0; i<n ; ++i){
            if( nums[i] < pivot ){
                rs[left++] = nums[i] ; 
            }
            if(  nums[n-i-1] > pivot ){
                rs[right--] = nums[n-i-1] ; 
            }
        }
    
        for(int i=left ; i<=right ; ++i){
            rs[i] = pivot ; 
        }
        return rs ; 
    }
}