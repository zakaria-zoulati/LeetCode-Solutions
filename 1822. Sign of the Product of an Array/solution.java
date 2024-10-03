class Solution {
    public int arraySign(int[] nums) {
        int rs = 1 ;
        for(int num : nums){
           if( num == 0  ) return 0 ; 
           else if( num < 0 ) rs = -rs ; 
        }
        return rs ; 
    }
}