class Solution {
    int max ; 
    public class Trie {
        Trie[] childs;
        int count;
        public Trie() {
            childs = new Trie[max+1]; 
            this.count = 0;
        }
        public int search(int[][] arr, int j, int in) {
            if (in == arr.length) {
                return count;
            }
            if (childs[arr[in][j]] == null) { 
                return 0;
            }
            return childs[arr[in][j]].search(arr, j, in + 1);
        }

        public void insert(int[] arr, int in) {
            if (in == arr.length) {
                this.count++;
                return;
            }
            if (childs[arr[in]] == null) {
                childs[arr[in]] = new Trie();
            }
            childs[arr[in]].insert(arr, in + 1);
        }
    }
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int rs = 0;
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                max = Math.max( grid[i][j] , max ) ; 
            }
        } 
        // Compute all the rows in a Trie
        Trie root = new Trie();
        for (int i = 0; i < n; ++i) {
            root.insert(grid[i], 0);
        }

        // Search for each column the number of matching rows
        for (int j = 0; j < n; ++j) {
            rs += root.search(grid, j, 0);
        }

        return rs;
    }
}
