class Solution {
    List<String> rs = new ArrayList<>() ; 
    Trie trie ; 
    class Trie {
        Trie[] childs ; 
        int in ;
        public Trie(){
            this.childs = new Trie[26] ; 
            in = -1 ; 
        }
        public void insert( String s , int pos ){
            Trie root = this ; 
            for( char c : s.toCharArray() ){
                if( root.childs[ c - 'a' ] == null ){
                    root.childs[c-'a'] = new Trie() ; 
                }
                root = root.childs[c-'a'] ;
            } 
            root.in = pos ; 
        }
        public void check( String s , int in , List<Integer> curr , List<String> words ){
            Trie root = this ; 
            if( in == s.length() ){
                StringBuilder ele = new StringBuilder() ; 
                for( int i : curr ){
                    ele.append( words.get(i) ).append(" ") ; 
                }
                rs.add( ele.substring( 0 , ele.length() - 1 ) ) ; 
                return ; 
            }
            for( int i = in ; i < s.length() ; ++i ){
                root = root.childs[ s.charAt(i) - 'a' ] ; 
                if( root == null ) return ; 
                if( root.in != -1 ){
                    curr.add(root.in) ; 
                    trie.check( s , i+1 , curr , words ) ; 
                    curr.remove( curr.size() - 1 ) ; 
                }
            }
        }

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.trie = new Trie() ; 
        for( int i=0 ; i<wordDict.size()  ; ++i ){
            trie.insert( wordDict.get(i) , i ) ; 
        }
        trie.check( s , 0 , new ArrayList<>() , wordDict );
        return rs ; 
    }
}