class Solution {
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray() ;  
        int n = digits.length ;
        Arrays.sort( digits ) ;
        int rs = 0 ; 
        int curr = 1 ;
        for(int i=n-1 ; i>=0 ; i-=2){
            rs += (digits[i] - '0') * curr ; 
            if( i-1 >= 0 ){
                rs += (digits[i-1] - '0' )*curr ; 
            }
            curr *= 10 ; 
        }
        return rs ; 
    }
}