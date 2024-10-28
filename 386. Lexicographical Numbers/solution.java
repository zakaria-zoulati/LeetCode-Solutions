class Solution {
    public class Trie {
        Trie[] child ; 
        boolean end ; 
        public Trie(){
            child = new Trie[10] ; 
            this.end = false ; 
        }
    }
    public void insert( String in , Trie curr  ){
        for( int i=0 ; i<in.length() ; ++i ){
            if( curr.child[ in.charAt(i) - '0' ] == null ){
                curr.child[ in.charAt(i) - '0' ] = new Trie() ; 
            }
            curr = curr.child[ in.charAt(i) -'0' ] ; 
        }
        curr.end = true ; 
    }

    public void backtrack( List<Integer> list , Trie t , int val ){
        if( t.end  ){
            list.add( val ) ; 
        }
        for( int i=0; i<10 ; ++i ){
            if( t.child[i] != null ){
                backtrack( list , t.child[i] , val*10 +i ) ; 
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> rs = new ArrayList<>() ; 
        Trie root = new Trie() ; 
        for( int i=1 ; i<=n ; ++i ){
            insert( String.valueOf(i) , root ) ; 
        }

        backtrack( rs , root , 0 ) ; 
        return rs ;
    }
}