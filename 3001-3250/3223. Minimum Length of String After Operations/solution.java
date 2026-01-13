class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[128]; 
        for (byte c : s.getBytes()) {
            freq[c]++;
        }
        int rs = 0;
        for (int c:freq){
            if (c > 0){
                rs += (c+ 1)&1; 
                rs += 1;
            }
        }
        return rs;
    }
}
