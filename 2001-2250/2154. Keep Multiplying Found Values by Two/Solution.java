class Solution {
    boolean found( int[] nums , int x ){
        for( int num : nums ){
            if( num == x ) return true ; 
        }
        return false ; 
    }
    public int findFinalValue(int[] nums, int original) {
        while( found( nums , original ) ){
            original <<= 1 ;
        }   
        return original ; 
    }
}