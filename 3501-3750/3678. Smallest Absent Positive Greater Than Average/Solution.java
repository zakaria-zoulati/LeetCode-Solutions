class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length ;  
        int avg = 0 ;
        for( int i : nums ) avg += i ;
        avg /= n ; 
        Arrays.sort( nums ) ;
        int rs = Math.max( 1 , avg + 1 ) ; 
        for( int i : nums ){
            if( i == rs ) {
                rs++ ; 
            }
        }
        return rs ; 
    }
}