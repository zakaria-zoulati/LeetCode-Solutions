class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int rs = 0 ; 
        boolean[] t = new boolean[51] ; 
        for(int num : nums){
            if( t[num] ){
                rs ^= num ;
            }
            t[num] = true  ;
        }
        return rs ; 
    }
}