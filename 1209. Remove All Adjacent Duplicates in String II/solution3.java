class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[s.length()];
        for (char c : s.toCharArray()) {
            sb.append(c);
            int lastIndex = sb.length() - 1;
            if (lastIndex > 0 && sb.charAt(lastIndex) == sb.charAt(lastIndex - 1)) {
                freq[lastIndex] = freq[lastIndex - 1] + 1;
            } else {
                freq[lastIndex] = 1;
            }
            if (freq[lastIndex] == k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }
        return sb.toString();
    }
}
