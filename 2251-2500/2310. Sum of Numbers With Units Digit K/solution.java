class Solution {
    public int minimumNumbers(int num, int k) {
        if( num == 0 ) return 0 ; 
        if( num < k ){
            return -1 ; 
        }
        int c = -1  ; 
        for(int i=1 ; i<=10 ; ++i ){
            if( (k*i)%10 == (num)%10 ){
                c = i ; 
                break ; 
            }
        }
        if( c == -1 ){
            return -1 ; 
        }
        if( c*k > num ) return -1 ; 
        return c ; 
    }
}