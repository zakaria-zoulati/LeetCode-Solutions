class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int low = 1, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((nums[mid] > nums[mid + 1]) && (nums[mid] > nums[mid - 1]))
                return mid;
            else if (nums[mid] < nums[mid + 1])
                  low = mid + 1;
            else
                  high = mid - 1;
        }
        return -2;
    }
}
