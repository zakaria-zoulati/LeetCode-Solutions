class Solution {
    public int rev( int n ){
        int rs = 0 ; 
        while( n > 0 ){
            rs = rs*10 + n%10 ; 
            n /= 10 ;
        }
        return rs ; 
    }
    public int countDistinctIntegers(int[] nums) {
        boolean[] x = new boolean[1_000_001] ; 
        for( int num : nums ){
            x[num] = true ; 
            x[ rev(num) ] = true ; 
        }
        int rs = 0 ; 
        for( boolean b : x ){
            if( b ) ++rs ; 
        }
        return rs ; 
    }
}