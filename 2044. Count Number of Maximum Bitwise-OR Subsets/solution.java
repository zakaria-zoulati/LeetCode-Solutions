class Solution {
    int rs = 0 ; 
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length ; 
        int m = 0 ;
        for( int i : nums ){
            m |= i ; 
        }
        backtrack( nums , 0 , 0 , m ) ; 
        return rs ; 
    }
    public void backtrack( int[] nums , int curr , int in , int m ){
        if( in == nums.length ){
            if( curr == m ){
                rs++ ; 
            }
            return ; 
        }
        backtrack( nums , curr , in+1 , m ) ; 
        int next = curr | nums[in] ; 
        if( ( next & m ) == next ){
            backtrack( nums , next ,  in+1 ,m ) ; 
        }
    }
}