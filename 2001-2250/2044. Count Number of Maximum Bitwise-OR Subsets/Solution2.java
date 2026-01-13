class Solution2 {
    int rs = 0 ; 
    public int countMaxOrSubsets(int[] nums) {
        int m = 0 ;
        for(int i : nums ){
            m |=i; 
        }
        backtrack( nums ,0 ,0 ,m) ; 
        return rs ; 
    }
    public void backtrack( int[] nums , int curr , int in , int m ){
        if( ( curr & m ) == m ){
            rs += ( 1<< nums.length - in ) ; 
            return ; 
        }
        if( in == nums.length ){
            if( curr == m ){
                ++rs ; 
            }
            return ; 
        }
        ++in ; 
        backtrack( nums , curr , in , m ) ; 
        int next = curr|nums[in-1] ; 
        if( (next&m) == next ){
            backtrack( nums ,next ,in,m ) ; 
        }
        
    }
}