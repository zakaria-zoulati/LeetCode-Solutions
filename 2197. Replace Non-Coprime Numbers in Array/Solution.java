class Solution {
    int gcd( int a , int b ){
        while( b != 0 ){
            int t = a % b ; 
            a = b ; 
            b = t ; 
        }
        return a ;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length ; 
        int[] stack = new int[n] ;
        int in = 0 ; 
        stack[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            int curr = nums[i] ; 
            while( in != -1 ){
                int g = gcd( curr , stack[in] ) ; 
                if( g > 1 ){
                    curr = ( curr / g ) * stack[in--] ; 
                } else {
                    break ; 
                }
            }
            stack[++in] = curr ; 
        } 
        List<Integer> rs = new ArrayList<>() ;
        for( int i=0 ; i<=in ; ++i ){
            rs.add( stack[i] ) ; 
        }
        return rs ; 
    }
}