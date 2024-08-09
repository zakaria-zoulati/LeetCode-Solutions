class Solution {
    class FenWickTree {
        int[] arr; 
        int n;
        public FenWickTree(int n) {
            arr = new int[n];  
            this.n = n;
        }
        
        public int p(int n) {
            return n & -n;
        }
        public void insert(int index, int val) {
            while (index <n) {
                arr[index] += val;
                index += p(index); 
            }
        }
        
        public int sum(int x) {
            int rs = 0;
            while (x >= 1) {
                rs += arr[x];
                x -= p(x); 
            }
            return rs;
        }

        public int range(int start, int end) {
            return sum(end) - sum(start - 1);
        }
    }
    
    public int numTeams(int[] rating) {
        int n = rating.length;
        int rs = 0;
        int max = 0;
        
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, rating[i]);
        }

        FenWickTree tr1 = new FenWickTree(max + 1);
        FenWickTree tr2 = new FenWickTree(max + 1);
        
        for (int i = 0; i < n; ++i) {
            tr1.insert(rating[i], 1);
        }
        
        for (int i = 0; i < n; ++i) {
            int x = rating[i];
            tr1.insert(x, -1); 
            int LLess = tr2.sum(x - 1);  
            int RLess = tr1.sum(x - 1);  
            int LBig = tr2.range(x + 1, max); 
            int RBig = tr1.range(x + 1, max); 
            rs += LLess * RBig + LBig * RLess;
            tr2.insert(x, 1); 
        }
        
        return rs;
    }
}
