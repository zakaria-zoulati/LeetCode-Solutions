class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int n = nums.length ; 
       int rs = 0 ; 
       if( goal == 0 ){
            for( int i=0 ; i<n ; ++i ){
                if( nums[i] == 0  ){
                    int count = 1 ; 
                    while( i+1 < n && nums[i+1] == 0 ){
                        ++i ; 
                        ++count ; 
                    }
                    rs += count*( count + 1 ) >> 1 ; 
                }
            }
            return rs ; 
       }
       int sum = 0 ; 
       int prev = 1 ;
       int i=0 ; 
       while( i<n && nums[i] == 0 ){
            i++ ;
            prev++ ; 
       }
       int start = i ; 
       for( ; i<n ; ++i ){
            sum += nums[i] ; 
            if( sum == goal ){
                rs += prev ; 
            }else if( sum > goal ) {
                sum-- ; 
                prev = 1 ; 
                while( nums[1+start++] == 0 ){
                    prev++ ; 
                }
                rs += prev ; 
            }
       }
       return rs ; 
    }
}