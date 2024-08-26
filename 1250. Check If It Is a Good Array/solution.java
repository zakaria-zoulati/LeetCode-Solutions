class Solution {
    public int pgcd( int a , int b ){
            while( b!=0 ){
                int temp = a ; 
                a = b ; 
                b = temp%b ; 
            }
            return a ; 
    }
    public boolean isGoodArray(int[] nums) {
        int n = nums.length ; 
        if( n==1){
            return nums[0] == 1  ;  
        }
        int curr = pgcd( nums[0] , nums[1] ) ; 
        if( curr == 1 ) return true ; 
        for(int i=2 ; i<n ; ++i){
            curr = pgcd( nums[i] , curr  ) ; 
            if( curr == 1 ) return true ;
        }
        return false ; 
    }
}