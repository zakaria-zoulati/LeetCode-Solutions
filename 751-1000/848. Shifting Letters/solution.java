class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        shifts[0] %= 26 ; 
        for (int i = 1; i < n; i++) {
            shifts[i] = (shifts[i - 1] +  shifts[i] ) % 26 ;
        }
        
        char[] chars = s.toCharArray();
        chars[0] = (char)  (( (chars[0] - 'a') + shifts[n-1] )%26 + 'a') ; 
        for (int i = 1; i < n; i++) {
            int shift = (shifts[n - 1] - shifts[i-1] + 26  ) % 26 ;
            chars[i] = (char) ( ( (chars[i] - 'a') + shift) % 26  + 'a' );
        }
        return new String(chars);
    }
}