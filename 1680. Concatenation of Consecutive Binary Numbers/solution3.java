class Solution {
	public int concatenatedBinary(int n) {
		long result = 1L;
		int mod = 1_000_000_007;
		int factor = 2;
		for (int i = 2; i < n + 1; i++) {
			if (i == factor) {
				factor <<= 1;
			}
			result = ((result * factor) + i) % mod;
		}
		return (int) result;
	}
}