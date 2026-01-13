class Solution {
    public int maximum69Number(int num) {
        for( int i=9 ; i>=0 ; --i ){
            int curr = num / (int)Math.pow( 10 , i ) ; 
            if( curr % 10 == 6 ){
                num += 3*Math.pow( 10 , i ) ; 
                return num ; 
            }
        }
        return num ; 
    }
}
