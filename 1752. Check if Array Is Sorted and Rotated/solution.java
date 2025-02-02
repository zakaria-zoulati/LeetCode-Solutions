class Solution {
    public boolean check(int[] nums) {
        int n = nums.length ; 
        int in = -1; 
        int curr = Integer.MAX_VALUE ;  
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] <= curr ){
                in = i ; 
                curr= nums[i] ;
            }
            while( i+1<n && nums[i+1] == nums[i] ){
                ++i ; 
            }
        }
        for( int i=1 ; i<n ; ++i ){
            if( nums[ (in+i)%n ] < nums[ (in+i-1)%n ] ){
                return false ; 
            }
        }
        return true ; 
    }
}