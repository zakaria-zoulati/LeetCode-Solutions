class Solution {
    public:
        int countVowelPermutation(int n) {
            int mod = 1e9 + 7 ; 
            long a=1 ,e=1 , u=1 , i=1 ,o=1 ; 
            for( int j=1 ; j<n ; ++j ){
                int na , ne , nu , ni , no ; 
                na = ( i + e + u ) % mod ; 
                ne = ( i + a  ) % mod ; 
                nu = ( i + o ) % mod ; 
                ni = ( e + o ) % mod ; 
                no = ( i ) % mod ; 
                a=na , e=ne , u=nu , i=ni , o=no ; 
            }
            return ( a + e + u + i + o ) % mod ; 
        }
    };