class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] all = new char[n];  
        for (int i = 0; i < n; ++i) {
            all[indices[i]] = s.charAt(i);
        }
        return new String(all); 
    }
}
