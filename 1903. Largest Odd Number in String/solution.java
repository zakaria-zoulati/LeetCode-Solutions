class Solution {
    public String largestOddNumber(String num) {
        int n = num.length() ; 
        for( int i = n-1 ; i>=0 ; --i ){
            int diff = num.charAt(i) - '0' ; 
            if( diff % 2 == 0  ) continue ; 
            else return num.substring(0,i+1) ; 
        }
        return "" ; 
    }
}