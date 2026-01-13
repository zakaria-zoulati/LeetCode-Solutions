class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length ; 
        int ones  = 0 ; 
        for(int i=0 ; i<n; i++){
            if( nums[i]==1 ){
                ones++ ; 
            }
        }
        if( ones == n ){
            return 0  ; 
        }
       int first = 0 ; 
       for(int i=0 ; i<ones ; i++){
            if( nums[i] == 1 ){
                first++ ; 
            }
       }
       int cost = ones - first ; 
       for(int i=1 ; i<n ;i++){
            if( nums[i-1] == 1 ){
                first--  ;
            }
            if( nums[ (i+ones+n-1)%n] == 1 ){
                first++; 
            }
            cost = Math.min( ones - first , cost ) ; 
       }
       return cost ; 
      
  }
}