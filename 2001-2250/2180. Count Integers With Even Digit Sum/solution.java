class Solution {
    public int sum( int n  ){
        int rs = 0 ; 
        while( n > 0 ){
            rs += n%10 ; 
            n /= 10 ; 
        }

        return rs ;
    }
    public int countEven(int num) {
       int rs = 0 ; 
       for(int i=1 ; i<=num ; ++i ){
            if( sum(i) % 2 == 0 ) rs++ ; 
       }
       return rs ; 
    }
}