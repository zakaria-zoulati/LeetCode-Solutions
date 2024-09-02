class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int cnt = 0;
        while(right < nums.length){
            if(nums[left] < nums[right]){
                left++;
                right++;
                cnt++;
            }else {
                right++;
            }
        }
        return cnt;
    }
}