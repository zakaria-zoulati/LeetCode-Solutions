class Solution {
    public int commonFactors(int a, int b) {
        int rs = 0 ; 
        int min = Math.min(a,b) ; 
        for(int i=1 ; i<= min ; ++i ){
            if( a%i == 0 && b%i == 0 ) rs++ ; 
        }
        return rs ;
    }
}