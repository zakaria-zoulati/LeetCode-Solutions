class Solution {
    public List<Integer> grayCode(int n) {
        int top = (1<<n) - 1 ; 
        List<Integer> rs = new ArrayList<>() ; 
        for( int i=0 ; i<=top ; ++i ){
            rs.add( i^(i>>1)) ; 
        }
        return rs ; 
    }
}