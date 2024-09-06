class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] chars = s.toCharArray();
        shifts[n - 1] = shifts[n - 1] % 26;
        for(int i=n-2;i>= 0;i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] = shifts[i] % 26;
        }
        for(int i = 0; i < n; ++i){
            chars[i] = (char)((((chars[i] - 'a') + shifts[i] ) % 26) + 97);
        }

        return new String(chars);
    }
}