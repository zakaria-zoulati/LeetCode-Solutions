class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] ndict = new int[301];
        for(int nu : nums) {
            ndict[nu] += 1;
        }
        int cnt = 0;
        for(int i=0; i < n; i++) {
            for(int j=i+1; j < n; j++) {
                for(int k=j+1; k < n; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if(ndict[sum] > 0) {
                        for(int l=k+1; l < n; l++) {
                            if(nums[l] == sum)
                                cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}