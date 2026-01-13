class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length() ; 
        int left = 0 ; 
        int right = n-1 ; 
        char[] arr = new  char[n] ;
        while( left <= right ){
            char a = s.charAt(left) ; 
            char b =  s.charAt(right) ; 
        if( a < b ){
            arr[left] = a ;
            arr[right] = a ;
        }else if( b < a ){
            arr[left] = b ;
            arr[right] = b ;
        }else {
            arr[left] = a ; 
            arr[right] = a ;
        }
            ++left ; 
            --right;
        }
        return new String(arr) ;   
    }
}