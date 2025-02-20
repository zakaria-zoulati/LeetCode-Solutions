class Solution {
    public class Trie{
        Trie[] childs ; 
        public Trie() {
            this.childs = new Trie[2] ; 
        }
        public void insert( String s , int i ){
            if( i == s.length() ){
                return ; 
            }
            int idx = s.charAt(i) - '0' ; 
            if( this.childs[idx] == null ){
                this.childs[idx] = new Trie() ;
            }
            this.childs[idx].insert(  s , i+1 ) ; 
        }
        // Check That a string is not in the Trie
        public boolean check( char[] chars , int i ){
            if( i == chars.length ){
                return false ; 
            }
            int idx = chars[i] - '0' ; 
            if( this.childs[idx] == null ) {
                return true ; 
            }
            return this.childs[idx].check( chars , i+1 ) ;
        }
    }
    public boolean backtrack( char[] chars , int i , Trie trie ){
        if( i == chars.length ){
            return trie.check( chars , 0 ) ; 
        }
        chars[i] = '0' ;
        if( backtrack( chars , i+1 , trie ) ){
            return true ; 
        }
        chars[i] = '1' ; 
        if( backtrack( chars , i+1 , trie ) ){
            return true ; 
        }
        return false ; 
    }
    public String findDifferentBinaryString(String[] nums) {
        Trie trie = new Trie() ; 
        int n = nums.length ; 
        for( int i=0 ; i<n ; ++i ){
            trie.insert( nums[i] , 0 ) ; 
        }
        char[] chars = new char[n] ; 
        chars[0] = '0' ; 
        if(backtrack( chars , 1 , trie )){
            return new String( chars ) ; 
        } 
        chars[0] = '1' ; 
        backtrack( chars , 1 , trie );
        return new String( chars ) ; 
    }
}