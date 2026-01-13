class Solution {
    public int distinctPrimeFactors(int[] nums) {
        boolean[] flag = new boolean[1001]; 
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    flag[factor] = true;
                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }
            if (num > 1) {
                flag[num] = true;
            }
        }

        int result = 0;
        for (int i = 2; i < 1001; i++) {
            if (flag[i]) {
                result++;
            }
        }

        return result;
    }
}
