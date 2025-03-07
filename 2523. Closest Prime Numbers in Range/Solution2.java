import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public boolean isPrime( int n ){
        if( n == 1 ) return false ; 
        if( n == 2 || n == 3 ){
            return true ; 
        }
        if( n % 2 == 0 || n % 3 == 0 ) return false ; 
        int i = 5 ; 
        while( i*i <= n ){
            if( n % i == 0 || n % (i+2) == 0 ){
                return false ; 
            }
            i += 6 ; 
        }
        return true ;
    }
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>() ; 
        for( int i=left ; i<=right ; ++i ){
            if( isPrime(i) ){
                if (!primes.isEmpty() &&
                    i <= primes.get(primes.size() - 1) + 2
                ) {
                    return new int[] {
                        primes.get(primes.size() - 1),
                        i
                    };
                }
                primes.add(i) ; 
            }
        }
        if( primes.size() < 2 ){
            return new int[]{-1,-1} ; 
        }
        int curr = 1_000_000 ; 
        int[] rs = new int[]{-1,-1} ; 
        for( int i=0 ; i<primes.size()-1; ++i ){
            int distance = primes.get(i+1) - primes.get(i) ; 
            if( distance < curr ){
                curr = distance ; 
                rs[0] = primes.get(i) ; 
                rs[1] = primes.get(i+1) ; 
            }
        }
        return rs ; 
    }
} 