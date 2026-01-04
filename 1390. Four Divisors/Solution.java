class Solution {
    static int[] scores = new int[ 1_00_001 ] ; 
    static {
        scores[1] = 0 ; 
        Arrays.fill( scores , -1 ) ; 
    }
    public boolean isPrime( int n ){
        if( n == 2 || n == 3 ) return true ; 
        if( n <= 1 ) return false ; 
        if( n % 2 == 0 || n % 3 == 0 ) return false ; 
        for( int i=5 ; i*i<=n ; i += 6 ){
            if( n % i == 0 || n % ( i + 2 ) == 0 ){
                return false ;
            } 
        }
        scores[n] = 0 ; 
        return true ; 
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0 ; 
        for( int num : nums ){
            if( scores[num] != -1 ){
                ans += scores[num] ; 
            }else if( isPrime( num ) ){
                scores[num] = 0 ; 
            }else {
                int curr = num ; 
                for( int i=2 ; i*i <= num ; ++i ){
                    if( curr % i == 0 ){
                        curr /= i ; 
                        if( curr % i == 0 ){
                            if( curr / i == i ){
                                scores[num] = num + 1 + i + i*i ; 
                                ans += scores[num] ; 
                            }else {
                                scores[num] = 0;  
                            }
                        }else if( isPrime( curr ) ) {
                            scores[num] = num + 1 + i + curr ; 
                            ans += scores[num] ; 
                        }else {
                            scores[num] = 0 ; 
                        }
                        break ; 
                    }
                }
            }
        }
        return ans ; 
    }   
}