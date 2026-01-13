class Solution {
    public int totalNumbers(int[] digits) {
        int[] f = new int[10]; 
        for (int i : digits) f[i]++; 
        int rs = 0; 
        for (int i = 0; i < 10; i += 2) {
            if (f[i] == 0) continue; 
            f[i]--; 
            for (int j = 1; j < 10; j++) {
                if (f[j] == 0) continue; 
                f[j]--; 
                for (int k = 0; k < 10; k++) {
                    if (f[k] != 0) rs++; 
                }
                f[j]++; 
            }
            f[i]++; 
        }
        return rs; 
    }
}
