class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] rs = new int[nums.length] ; 
        int p = 0 ; 
        int n = 1 ; 
        for(int a : nums){
            if( a>0 ){
                rs[p] = a ; 
                p += 2 ; 
            }else {
                rs[n] = a ; 
                n += 2 ;
            }
        }
        return rs ; 
    }
}