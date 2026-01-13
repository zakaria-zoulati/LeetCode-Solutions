class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> rs = new ArrayList<>() ; 
        int m = 0 ; 
        for (; start >0 ; start >>= 1){
            m ^= start ; 
        }
        int top = ( 1 << n ) - 1 ; 
        for( int i=m ; i<=top ; ++i ){
            rs.add( i ^ ( i >> 1 ) ) ; 
        }
        for( int i=0 ; i<m ; ++i ){
            rs.add( i ^ ( i >> 1 ) ) ;
        }
        return rs ; 
    }
}