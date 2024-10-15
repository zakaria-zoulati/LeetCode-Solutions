class Solution {
    public int rev( int n ){
        int rs = 0 ; 
        while( n>0 ){
            rs = rs*10 + n%10 ; 
            n /= 10 ; 
        }
        return rs ; 
    }
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0 ; i<=num ; ++i){
            if( ( i + rev(i) ) == num ) {
                System.out.println(i) ; 
                return true ; 
            }
        }
        return false  ; 
    }
}