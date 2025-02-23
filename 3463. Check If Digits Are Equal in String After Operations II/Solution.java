class Solution {
   public boolean hasSameDigits(String s) {
       int n = s.length();
       if (n == 2) {
           return s.charAt(0) == s.charAt(1);
       }
       long a = 0;
       long b = 0;
       for (int i = 0; i < n - 1; i++) {
           int coeff = comb10( i , n-2 ) ; 
           a = (a + coeff * (s.charAt(i) - '0')) % 10;
           b = (b + coeff * (s.charAt(i + 1) - '0')) % 10;
       }
       
       return a == b;
   }

   public int comb10(int k ,int n ){
        if( k == 0 || k == n ){
            return 1 ; 
        }
        int a = comb2( k , n ) ; 
        int b = comb5( k , n ) ; 
        for( int i=0 ; i<10 ; ++i ){
            if( i%2 == a && i%5 == b ){
                return i ;
            }
        }
        return -1 ; 
   }

    public int comb2(int k , int n ){
        while( k >0 || k>0 ){
            if( (k&1) > (n&1) ){
                return 0 ; 
            }
            n >>= 1 ; 
            k >>= 1 ; 
        }
        return 1 ; 
    }

    public int comb5( int k , int n ){
        int rs = 1 ; 
        while( k>0 || n>0 ){
            int a = k%5 ; 
            int b = n%5  ;
            if( a > b ){
                return 0  ;
            }
            rs = rs * helper( a , b ) % 5 ; 
            n /= 5  ;
            k /= 5 ; 
        }
        return rs ; 
    }

    public int helper( int k , int n ){
        int[] fact = new int[]{ 1 , 1 , 2 , 6 , 24 } ; 
        int up = fact[n] ; 
        int denominent = fact[k]*fact[n-k] ; 
        int rs = up/denominent ; 
        return rs%5 ; 
    }   
}
