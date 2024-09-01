class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int rs = 0 ; 
        int n = nums.length ; 
        int count = 0 ; 
        int diff = 0 ;
        for(int i=0 ; i+2<n ; ++i){
           diff = nums[i+1] - nums[i] ;
           count = 2 ; 
           int j = i+1 ; 
            while( j+1<n && nums[j+1] - nums[j] == diff ){
                count++ ; 
                j++ ;
            }
            if( count>=3 ){
                rs += count -2 ; 
            }
            count = 0 ; 
        }
        return rs  ; 
    }
}