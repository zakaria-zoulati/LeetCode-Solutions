class Solution {
    public int maximumXOR(int[] nums) {
        int n = nums.length  ; 
        int rs = 0 ;
        for(int item : nums  ){
           rs |= item ;
        }

        return rs ;
    }
}