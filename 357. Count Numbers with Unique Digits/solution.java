class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if( n==0 ){
            return 1 ; 
        }
        int base = 10 ; 
        if( n==1 ){
            return base ; 
        }
        int rs = base ; 
        int holded = 9 ; 
        int inter = 9 ; 
        for(int i=2; i<=n ; ++i){
            holded *= inter-- ; 
            rs += holded ; 
        }
        return rs ; 
        
    }
}