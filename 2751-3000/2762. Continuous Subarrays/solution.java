class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length ; 
        long rs = 0L ; 
        int left = 0 ; 
        int min = nums[0] ; 
        int max = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            min = Math.min(nums[i] , min) ; 
            max = Math.max(nums[i] , max) ; 
            if(max - min > 2){
                int win = i - left ; 
                rs += (long) win*(win+1)/2 ;
                min = nums[i] ; 
                max = nums[i] ; 
                left = i ; 
                while( left>0 && Math.abs(nums[left-1] - nums[i] ) <= 2 ){
                    left-- ; 
                    min = Math.min(nums[left] , min); 
                    max = Math.max(nums[left] , max); 
                } 
                int diff = i-left  ; 
                rs -= (long) diff*(diff+1)/2 ; 
            }
        }   
        rs += (long) (n - left)*(n-left + 1 )/2 ; 
        return rs; 
    }
}