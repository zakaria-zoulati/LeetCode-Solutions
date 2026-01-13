class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length ; 
        int rs = 1 ; 
        for(int i=0;i+1<n ;){
            int curr = 1 ; 
            if( nums[i+1] == nums[i] ){
                while( i+1<n && nums[i+1] == nums[i] ){
                    ++i ; 
                }
            }
            else if(nums[i+1] > nums[i] ){
                while( i+1<n && nums[i+1] > nums[i] ){
                    ++i ; 
                    ++curr ; 
                }
            }else {
                while( i+1<n && nums[i+1] < nums[i] ){
                    ++i ; 
                    ++curr ; 
                }
            }
            if( curr > rs ){
                rs = curr ; 
            }
        }
        return rs ; 
    }
}