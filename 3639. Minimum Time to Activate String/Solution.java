class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length(); 
        long curr = 0;  
        TreeSet<Integer> arr = new TreeSet<>(); 
        arr.add(-1); 
        arr.add(n); 
        for (int i = 0; i < n; ++i) {
            int a = order[i]; 
            int l = arr.lower(a); 
            int r = arr.higher(a); 
            curr += (long)(a - l) * (r - a); 
            if (curr >= k) return i; 
            arr.add(a); 
        }
        return -1; 
    }
}
