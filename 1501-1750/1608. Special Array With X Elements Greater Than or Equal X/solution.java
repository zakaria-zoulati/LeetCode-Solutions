class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums) ; 
        int n = nums.length ; 
        int inter = n ; 
        for(int i=0 ; i<n ; i++){
            if( nums[i] >= inter ){
                if( i-1>=0 ){
                    if( nums[i-1] < inter   ){
                        return inter ; 
                    }
                }else {
                     return inter ;
                }
            }
            inter-- ; 
        }
        return -1  ; 
    }
}