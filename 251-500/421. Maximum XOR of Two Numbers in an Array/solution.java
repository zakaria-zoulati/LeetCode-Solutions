class Solution {
    public class Trie {
        Trie[] childs ; 
        public Trie(){
            this.childs = new Trie[2] ; 
        }
        public void insert( int[] arr , int in ){
            if( in == -1 ){
                return ; 
            }
            int i = arr[in] ; 
            if( childs[i] == null ){
                childs[i] = new Trie() ; 
            }
            childs[i].insert( arr , in-1 ) ; 
        }
        public int check( int[] arr , int rs , int in ){
            if( in == -1 ){
                return rs ; 
            }
            int curr = 1 - arr[in] ; 
            if( childs[curr] != null ){
                rs += 1 << in ; 
                return childs[curr].check( arr , rs , in-1 ) ;
            }else if( childs[ arr[in] ] != null ) {
                return childs[ arr[in] ].check( arr , rs , in-1 ) ; 
            }else {
                return -1 ; 
            }
        }
    }
    public int findMaximumXOR(int[] nums) {
        int rs = 0 ; 
        Trie root = new Trie() ; 
        for( int i : nums ){
            int[] arr = new int[32] ; 
            int in = 0 ;
            while( i > 0 ){
                arr[in++] = i%2 ;
                i >>= 1 ; 
            }
            rs = Math.max( rs , root.check(arr , 0 , 31) ) ; 
            root.insert( arr , 31 ) ;
        }
        return rs ; 
    }
}