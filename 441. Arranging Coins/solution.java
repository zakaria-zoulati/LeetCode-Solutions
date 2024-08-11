class Solution {
    public int arrangeCoins(int n) {
        long left = 1; 
        long right = (long) 1e5; 
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long curr = mid * (mid + 1) / 2;  
            if (curr == n) {
                return (int) mid; 
            } else if (curr < n) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return (int) right; 
    }
}

