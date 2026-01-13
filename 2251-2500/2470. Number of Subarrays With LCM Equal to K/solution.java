class Solution {
    public int gcd( int a , int b ){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a ; 
    }
    public int lcm( int a , int b ){
        return (a*b)/gcd( a , b ) ; 
    }
    public int subarrayLCM(int[] nums, int k) {
        int rs = 0 ;
        int n = nums.length ; 
        int count = 0 ; 
        int current = 0 ; 
        for(int i= 0 ; i<n ; ++i ){
           if( k % nums[i] != 0 ) continue ; 
           if( nums[i] == k ){
                rs++ ; 
                int j=i ; 
                while( j+1 <n && k%nums[j+1] == 0 ){
                    j++ ; 
                    rs++ ;
                }
           }else{
               current = nums[i] ; 
               int j=i ; 
               while( j+1<n && lcm( current , nums[j+1] ) <=k  ){
                    current = lcm(  current , nums[j+1] ) ; 
                    j++ ; 
                    if( current == k ){
                        rs++ ; 
                    }
               }
           }
        }
        return rs ;
    }
}