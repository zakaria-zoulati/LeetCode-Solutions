class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length ; 
        int curr = 0 ; 
        int k = n ; 
        for(int i=0 ; i<n ; ++i ){
            nums[curr++] = nums[i] ; 
            if( i+1<n &&  nums[i] == nums[i+1] ){
                i++ ; 
                nums[curr++] = nums[i] ; 
            }

            while( i+1<n  && nums[i] == nums[i+1] ){
                --k ; 
                i++ ; 
            }
        }
        return k ; 
    }
}