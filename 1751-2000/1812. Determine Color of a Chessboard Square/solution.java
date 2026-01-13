class Solution {
    public boolean squareIsWhite(String coordinates) {
        if( (coordinates.charAt(0) - 'a') % 2 ==0 ){
            return  (coordinates.charAt(1) - '0') % 2 == 0 ; 
        }else {
            return  (coordinates.charAt(1) - '0') % 2 == 1 ; 
        }
    }
}