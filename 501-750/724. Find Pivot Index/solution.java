class Solution {
    public int pivotIndex(int[] nums) {
        int n= nums.length ;
        if(n==1){
            return 0 ;
        }
        int sum = 0 ; 
        for(int i=0; i<n ;i++){
            sum += nums[i] ;
        }
        if(sum-nums[0]==0){
            return 0 ;
        }
        
        int right = nums[0] ; 
        int left = sum - nums[0] - nums[1] ;
        for(int i = 1 ; i<n-1 ; i++){
            if(right==left){
                return i ;
            }
            right+= nums[i] ;
            left-=nums[i+1] ;
        }
        if(sum-nums[n-1]==0){
            return n-1 ;
        }
        return -1 ;
    }
}