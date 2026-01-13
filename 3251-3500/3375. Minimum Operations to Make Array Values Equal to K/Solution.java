class Solution {
    public int minOperations(int[] nums, int k) {
        int[] f = new int[101] ; 
        int min = 200 ; 
        for( int i : nums ){
            f[i]++ ; 
            min = Math.min(min,i) ; 
        }
        if( min < k ) return -1 ; 
        int rs = 0 ; 
        for( int i=100 ; i>k ; --i  ){
            if( f[i] > 0 ){
                rs++ ; 
            }
        }
        return rs; 
    }
}