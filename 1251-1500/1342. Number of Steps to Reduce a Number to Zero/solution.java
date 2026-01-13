class Solution {
    public int numberOfSteps(int num) {
        int rs  = 0 ; 
        while( num != 0 ){
            if( (num&1) == 1 ){
                num -= 1 ; 
            }else {
                num >>= 1 ; 
            }
            rs++ ; 
        }
        return rs ; 
    }
}