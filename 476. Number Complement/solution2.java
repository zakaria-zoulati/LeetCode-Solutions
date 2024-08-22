class Solution {
    public int findComplement(int num) {
       String inter = String.valueOf( num ) ;
       int a = 0 ; 
       int b = num ;
       while( b !=0  ){
            b >>= 1 ;
            a++ ;
       }
       return ( (1<<a) - num  ) -1  ; 
    }
}