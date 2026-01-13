class Solution {
    int n;
    int k;
    List<List<Integer>> rs;
    public List<List<Integer>> combine(int n, int k) {
        rs = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrack(new ArrayList<>(), 1);
        return rs;
    }
    public void backtrack(List<Integer> curr, int ind) {
        if (curr.size() == k) {
            rs.add(new ArrayList<>(curr)); 
            return;
        }
        for (int i = ind; i <= n-(k - curr.size()) + 1; ++i) {
            curr.add(i);
            backtrack(curr,i+1); 
            curr.remove(curr.size()-1); 
        }
    }
}
