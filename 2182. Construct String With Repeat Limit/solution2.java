class Solution {
    public String repeatLimitedString(String s, int k){ 
        byte[] res; // the Chars of s as Bytes ( res.length == s.length() )
        int resP = 0; // Th pointer inside The res Byte array 
        int[] freqs = new int[26];
        for (byte aChar : (res = s.getBytes())) ++freqs[aChar - 97];
        
        for (int i = 25, j; i >= 0; i = j) {
            j = i - 1;
            while (freqs[i] > k) {
                for (int _j = 0; _j < k; ++_j) res[resP++] = (byte) (97 + i);
                freqs[i] -= k;
                for (; j >= 0 && freqs[j] == 0; --j) ;
                if (j < 0) return new String(res, 0, resP);
                res[resP++] = (byte) (97 + j);
                --freqs[j];
            }
            for (int _j = freqs[i]; _j > 0; --_j) res[resP++] = (byte) (97 + i);
        }
        
        return new String(res);
    }
}