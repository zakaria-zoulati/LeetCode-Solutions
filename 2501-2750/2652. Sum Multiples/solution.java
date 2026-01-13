class Solution {
    public int sumOfMultiples(int n) {
        int rs = 0 ; 
        for(int i=3 ; i<=n ; i++){
            if( i%3 == 0 || i%5 == 0 || i%7 == 0 ){
                rs += i ; 
            }
        }
        return rs ;
    }
}