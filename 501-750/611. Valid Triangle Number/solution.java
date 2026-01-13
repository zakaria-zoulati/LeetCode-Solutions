class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int rs = 0;
        if (n < 3) {
            return rs;
        }
        Arrays.sort(nums);
        for (int i = 0; i+2< n ; i++) {
            ok:for(int k= n-1 ; k>=i+2 ; k--){
                for(int j= i+1; j<k ; ++j){
                    if( nums[i] + nums[j] > nums[k] ){
                        rs += k- j ; 
                        continue ok ; 
                    }
                }
            }
            
        }

        return rs;
    }
}