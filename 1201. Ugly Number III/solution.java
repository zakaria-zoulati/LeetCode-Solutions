
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1 ; 
        long right = 2*((long) 1e9 ) ; 
        while( left < right ){
            long middle = left + (right-left)/2 ; 
            long inter = middle/a + middle/b + middle/c + middle/lcm(a,lcm(b,c))  - middle/lcm(a,b) - middle/lcm(a,c)  - middle/lcm(c,b)  ; 
            if( inter < n ){
                left = middle +1 ; 
            }else{
                right = middle ;
            }
        }
        return (int) left  ; 
    }

    public long gcd(long a , long b){
        while( b!=0  ){
            long tmp = b ; 
            b = a%b ; 
            a= tmp; 
        }
        return a ; 
    }

    public long lcm( long a , long b ){
        return a/gcd(a,b)*b ; 
    }
}
