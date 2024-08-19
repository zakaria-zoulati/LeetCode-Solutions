class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length ; 
        Arrays.sort(nums) ; 
        int rs = 0 ; 
        int l = 0 ; 
        int r = n-1 ; 
        while(l<r){
            int sum = nums[l] + nums[r] ; 
            if( sum > rs ){
                rs = sum ; 
            }
            l++;
            r-- ; 
        }
        return rs ; 
    }
}