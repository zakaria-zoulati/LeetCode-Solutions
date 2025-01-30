class Solution {
    class Trie {
        Trie[] childs ; 
        List<String> words ; 
        static int[] map = new int[128] ; 
        static {
            for (char i = 'a'; i <= 'z'; ++i) {
                map[i] = i - 'a';
            }
        }
        public Trie() {
            this.childs = new Trie[26] ; 
            this.words = new ArrayList<>() ; 
        }
        public void insertFirst( String word , int in ){
            if( in == word.length() ){
                return ; 
            }
            int i = map[word.charAt(in)] ;
            if( childs[i] == null ){
                childs[i] = new Trie() ; 
            }
            childs[i].insertFirst(word,in+1); 
        }
        public void insert( String word , int in ){
            if( in == word.length() ){
                return ; 
            }
            int i = map[word.charAt(in)] ;
            if( childs[i] == null ){
                return ; 
            }
            if( childs[i].words.size() < 3){
                childs[i].words.add(word);
            }
            childs[i].insert(word,in+1); 
        }
        public void check( List<List<String>> rs , String prefix , int in ){
            if( in == prefix.length() ){
                return ;
            }
            int i = map[prefix.charAt(in)] ;
            if( this.childs[i] == null ){
                return ; 
            }
            rs.add( childs[i].words ) ;
            childs[i].check( rs , prefix , in+1 ) ; 
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort( products ) ;
        List<List<String>> rs = new ArrayList<>() ; 
        Trie root = new Trie() ; 
        root.insertFirst( searchWord , 0 ) ; 
        for( String i : products ){
            root.insert(i,0)  ; 
        }
        root.check(rs,searchWord,0); 
        while( rs.size() < searchWord.length() ){
            rs.add( new ArrayList<>() ) ; 
        }
        return rs ; 
    }
}