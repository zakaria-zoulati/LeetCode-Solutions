class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[32] ; 
        for( int num : candidates ){
            int i = 0 ;
            while( num > 0 ){
                if( num % 2 == 1  ){
                    bits[i]++ ; 
                }
                ++i ; 
                num >>= 1; 
            }
        }
        int rs = 0 ; 
        for( int i : bits )
            rs = Math.max( rs , i ) ; 
        return rs ; 
    }
}