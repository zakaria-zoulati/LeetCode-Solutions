class Solution {
    public int sumP(int n) {
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n >>= 1; 
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }

        if (n > 1) {
            sum += n;
        }
        return sum;
    }

    public int smallestValue(int n) {
        int k = 0;
        while (true) {
            k = sumP(n);
            if (n == k) {
                return n;
            }
            n = k;
        }
    }
}
