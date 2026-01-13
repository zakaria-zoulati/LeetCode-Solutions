class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int rs = 0;

        int[] firstDigits = new int[n];
        for (int i = 0; i < n; ++i) {
            firstDigits[i] = firstDigit(nums[i]);
        }
        
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[j] % 10, firstDigits[i]) == 1) {
                    rs++;
                }
            }
        }
        return rs;
    }

    public int firstDigit(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }
}
