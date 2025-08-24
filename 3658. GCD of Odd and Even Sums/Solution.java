class Solution {
    int gcd( int a , int b ){
        while( b!=0 ){
            int t = a%b ; 
            a = b ; 
            b = t ; 
        }
        return a;  
    }
    public int gcdOfOddEvenSums(int n) {
        int a = 0; 
        int b = 0 ; 
        for( int i=1 ; i<=n ; ++i ){
            a += 2*i ; 
            b += ( 2*(i-1) ) + 1 ; 
        }
        return gcd(a,b) ; 
    }
}