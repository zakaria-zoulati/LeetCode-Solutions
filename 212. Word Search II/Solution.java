class Trie {
    Trie[] childs = new Trie[26] ; 
    int in = -1 ; 
    public void insert(String s , int i) {
        Trie root = this;
        for (char c : s.toCharArray()) {
            if (root.childs[c - 'a'] == null) {
                root.childs[c - 'a'] = new Trie();
            }
            root = root.childs[c - 'a'];
        }
        root.in = i;
    }
}
class Solution {
    Trie trie ; 
    char[][] board ; 
    String[] words ; 
    int n , m ; 
    List<String> rs ; 
    public List<String> findWords(char[][] board, String[] words) {
        this.trie = new Trie();
        this.n = board.length;
        this.m = board[0].length;
        this.rs = new ArrayList<>() ;
        this.words = words ;
        this.board = board ; 
        for (int i=0 ; i<words.length ; ++i ) {
            trie.insert( words[i] , i );
        }
        boolean[][] isSeen = new boolean[n][m];
        char[] chars = new char[10]; 

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dfs( i , j , this.trie ) ; 
            }
        }
        return rs;
    }
    public void dfs( int i , int j , Trie trie ){
        if( board[i][j] == '#' || trie.childs[ board[i][j] - 'a' ] == null ){
            return ; 
        }
        Trie next = trie.childs[ board[i][j] - 'a' ] ; 
        if( next.in != -1 ){
            rs.add( words[next.in] ) ; 
            next.in = -1 ; 
        }
        char store = board[i][j] ; 
        board[i][j] = '#' ; 
        if (i > 0) dfs(i - 1, j, next);
        if (j > 0) dfs(i, j - 1, next);
        if (i < n - 1) dfs(i + 1, j, next);    
        if (j < m - 1) dfs(i, j + 1, next);    
        board[i][j] = store ; 
    }
}