class Solution {
    public String removeTrailingZeros(String num) {
        int n = num.length()  ;
        boolean flag = true  ;
        int left = n-1  ;
        while( left >=0  && num.charAt(left) == '0' ){
            left--;  
        }
        return num.substring( 0 , left+1 ) ;
    }
}