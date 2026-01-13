class Solution {
    int n ; 
    int k ; 
    List<List<Integer>> rs ;
    public List<List<Integer>> combine(int n, int k) {
        rs = new ArrayList<>() ;    
        this.n = n ;
        this.k = k ; 
        backtrack( new ArrayList<>() , 0 ) ; 
        return rs; 
    }
    public void backtrack( List<Integer> curr , int ind ){
        if(curr.size()==k){
            rs.add(curr) ; 
            return ; 
        }
        for(int i=ind+1 ; n-i+1 >= k-curr.size() ; ++i ){
            List<Integer> next = new ArrayList<>(curr) ; 
            next.add(i) ; 
            backtrack( next , i ) ; 
        }
    }
}