/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

 class Solution {
    public int findInMountainArray(int target, MountainArray mo) {
        int n = mo.length();
        int left = 0, right = n - 1;
        int peak = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mo.get(mid) < mo.get(mid + 1)) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }
        peak = left; 
        int index = binarySearch(mo, target, 0, peak, true);
        if (index != -1) return index; 
        return binarySearch(mo, target, peak + 1, n - 1, false); 
    }

    private int binarySearch(MountainArray mo, int target, int left, int right, boolean isAsc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mo.get(mid);
            if (midValue == target) {
                return mid; 
            }
            if (isAsc) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1; 
                }
            } else {
                if (midValue > target) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
        }
        return -1; 
    }
}
