class Trie {
    Trie[] childs ; 
    boolean isEnd ;
    public Trie() {
        this.childs = new Trie[26] ; 
        this.isEnd = false ; 
    }
    public void insert(String word) {
        insert( word , 0 ) ; 
    }
    public boolean search(String word) {
        return search( word , 0 ) ; 
    }
    public boolean startsWith(String prefix) {
        return startsWith( prefix , 0 ) ; 
    }
    // My own methods 
    public void insert( String word , int in ){
        if( in == word.length() ){
            this.isEnd = true ; 
            return ; 
        }
        int i = word.charAt(in) - 'a' ; 
        if( childs[i] == null ){
            childs[i] = new Trie() ; 
        }
        childs[i].insert( word , in+1 ) ; 
    }
    public boolean startsWith(String prefix , int in ){
        if( in == prefix.length() ){
            return true ; 
        }
        int i = prefix.charAt(in) - 'a' ; 
        if( this.childs[i] == null ){
            return false ; 
        }
        return childs[i].startsWith( prefix , in+1 ) ; 
    }
    public boolean search(String word , int in ) {
        if( in == word.length()){
            return this.isEnd ; 
        }
        int i = word.charAt(in) - 'a' ; 
        if( childs[i] == null ){
            return false ; 
        }
        return childs[i].search( word , in+1 ) ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */