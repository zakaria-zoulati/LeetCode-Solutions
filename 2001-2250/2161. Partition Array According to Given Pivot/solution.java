class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        int e = 0 ; 
        int curr = 0 ;
        for(int i=0 ; i<n ; ++i){
            if( nums[i] < pivot ){
                rs[curr++] = nums[i] ; 
            }else if( nums[i] == pivot ){
                e++ ; 
            }
        }
        while( e-->0 ){
            rs[curr++] = pivot ; 
        }
        for(int i=0; i<n ; ++i){
            if( nums[i] > pivot ){
                rs[curr++] = nums[i] ; 
            }
        }

        return rs ; 
    }
}