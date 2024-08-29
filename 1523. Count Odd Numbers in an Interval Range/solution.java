class Solution {
    public int countOdds(int low, int high) {
        int rs = 0 ; 
        if( low % 2 == 0 ){
            low++  ;
        }
        if( high % 2 == 1  ){
            return (high - low)/2 + 1 ;
        }else {
            return ( high - low + 1 )/2 ; 
        }
    }
}