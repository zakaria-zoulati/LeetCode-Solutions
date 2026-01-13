class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int prev1 = 1, prev2 = 1;  
        int curr1, curr2; 
        int maxLen = 1;  
        
        for (int i = 1; i < n; ++i) {
            curr1 = curr2 = 1; 
            if (nums1[i] >= nums1[i - 1]) {
                curr1 = prev1 + 1;
            }
            if (nums1[i] >= nums2[i - 1]) {
                curr1 = Math.max(curr1, prev2 + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                curr2 = prev1 + 1;
            }
            if (nums2[i] >= nums2[i - 1]) {
                curr2 = Math.max(curr2, prev2 + 1);
            }
            maxLen = Math.max(maxLen, Math.max(curr1, curr2));
            prev1 = curr1;
            prev2 = curr2;
        }
        
        return maxLen;
    }
}
