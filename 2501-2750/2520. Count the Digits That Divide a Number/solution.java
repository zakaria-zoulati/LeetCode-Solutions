class Solution {
    public int countDigits(int num) {
        int rs =0 ; 
        int origin = num ; 
        while( num != 0 ){
            int inter = num%10 ; 
            if( inter!=0 && origin%inter ==0  ){
                rs++  ; 
            }
            num /= 10 ;
        }
        return rs ; 
    }
}