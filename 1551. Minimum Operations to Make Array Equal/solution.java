class Solution {
    public int minOperations(int n) {
        int mid = n / 2;
        int sum = 0;

        for (int i = 0; i < mid; ++i) {
            sum += n - 2 * i - 1;
        }
        return sum;
    }
}