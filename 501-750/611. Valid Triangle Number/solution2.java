import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int rs = 0;
        if (n < 3) {
            return rs;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = i + 2;
            while (j < n - 1 && k < n) {
                if (nums[i] + nums[j] > nums[k]) {
                    rs += k - j;
                    k++;
                } else {
                    j++;
                    if (k <= j) k = j + 1;  
                }
            }
        }

        return rs;
    }
}
