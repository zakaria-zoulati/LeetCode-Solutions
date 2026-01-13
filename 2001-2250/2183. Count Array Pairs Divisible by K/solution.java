class Solution {
    public int gcd( int a , int b ){
        while( b!=0 ){
            int temp = a ; 
            a = b ; 
            b = temp % b ; 
        }
        return a ; 
    }
    public void fill( HashMap<Integer,Integer> map , int factor ){
        for(int i : map.keySet() ){
            if( factor % i == 0 ) {
                map.put( i , map.get(i) + 1 ) ; 
            }
        }
    }
    int inter = 0 ; 
    public long countPairs(int[] nums, int k) {
        long rs = 0 ;
        int n = nums.length ; 
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        for(int i=2 ; i<=k/2 ; ++i){
            if( k%i == 0 ){
                map.put( i , 0 ) ; 
            }
        }
        int inter = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            if( nums[i] % k == 0  ){
                rs += (n-1 -inter) ;
                inter++; 
            }else {
                int curr = gcd( nums[i] , k ) ;
                if( curr == 1 ) continue ;  
                rs += map.getOrDefault( k/curr , 0 )  ; 
                fill( map , curr ) ; 
            }
            
        }
        return rs ; 
    }
}