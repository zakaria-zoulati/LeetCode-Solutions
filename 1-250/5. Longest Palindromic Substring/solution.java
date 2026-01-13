class Solution {
    int l , max ; 
    public String longestPalindrome(String s) {
        int n = s.length() ; 
        if( n <=1  ){
            return s ; 
        }
        for(int i=0; i<n-1 ;i++){
            extend(s,i,i) ; // Odd Palindrome
            extend(s,i,i+1) ; // Even Palindrome 
        }
        return s.substring(l,l+max) ; 
    }  
    public void extend(String s , int j , int k){
        while( j>=0 && k<s.length() && s.charAt(j)==s.charAt(k) ){
            j-- ; 
            k++ ;
        }
        if( max < k-j-1 ){
            max = k-j-1 ; 
            l = j+1 ; 
        }
    }
}