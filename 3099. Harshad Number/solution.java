class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int rs = 0 ; 
        int inter = x ; 
        while( inter != 0  ){
            rs += inter%10 ; 
            inter /= 10 ; 
        }
        if( x% rs == 0  ) return rs ; 
        return -1  ; 
    }
}