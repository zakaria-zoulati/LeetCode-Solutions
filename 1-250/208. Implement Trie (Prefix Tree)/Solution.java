class Trie {
    Trie[] childs ; 
    boolean isEnd ;
    static int[] map = new int[128] ; 
    static {
        for (char i = 'a'; i <= 'z'; ++i) {
            map[i] = i - 'a';
        }
    }
    public Trie() {
        this.childs = new Trie[26] ; 
        this.isEnd = false ; 
    }
    public void insert(String word) {
        insert(word,0) ; 
    }
    public boolean search(String word) {
        return search(word,0) ; 
    }
    public boolean startsWith(String prefix) {
        return startsWith(prefix,0) ; 
    }
    // My own methods 
    public void insert( String word , int in ){
        if( in == word.length() ){
            this.isEnd = true ; 
            return ; 
        }
        int i = map[word.charAt(in)] ;
        if( childs[i] == null ){
            childs[i] = new Trie() ; 
        }
        childs[i].insert( word , in+1 ) ; 
    }
    public boolean startsWith(String prefix , int in ){
        if( in == prefix.length() ){
            return true ; 
        }
        int i = map[prefix.charAt(in)] ;
        if( this.childs[i] == null ){
            return false ; 
        }
        return childs[i].startsWith( prefix , in+1 ) ; 
    }
    public boolean search(String word , int in ) {
        if( in == word.length()){
            return this.isEnd ; 
        }
        int i = map[word.charAt(in)] ;
        if( childs[i] == null ){
            return false ; 
        }
        return childs[i].search( word , in+1 ) ;
    }
}
