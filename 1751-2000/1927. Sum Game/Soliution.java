class Solution {
    public boolean sumGame(String num) {
        int n = num.length(); 
        int half1 = 0, half2 = 0, par1 = 0, par2 = 0; 
        char[] chars = num.toCharArray() ; 
        for (int i = 0; i < n; ++i) {
            char c = chars[i] ; 
            if (i < n / 2) {
                if (c == '?') par1++;
                else half1 += c - '0';
            } else {
                if (c == '?') par2++;
                else half2 += c - '0';
            }
        }

        if ((par1 + par2) % 2 == 1) return true;

        int min = Math.min(par1, par2);
        par1 -= min;
        par2 -= min;

        if (par1 == 0) {
            par2 >>= 1;
            return half1 != half2 + par2 * 9;
        } else {
            par1 >>= 1;
            return half2 != half1 + par1 * 9;
        }
    }
}
