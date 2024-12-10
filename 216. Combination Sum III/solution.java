class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rs = new ArrayList<>() ; 
        backtrack( rs , n , k , 0  , 1 ,  new ArrayList<>() ) ; 
        return rs ; 
    }

    public void backtrack( List<List<Integer>> rs , int n , int k , int curr , int next ,  ArrayList<Integer> cu  ){
        if( curr == n && cu.size() == k  ){
            rs.add( new ArrayList<>(cu) ) ; 
            return ; 
        }
        if( curr > n || next == 10 || cu.size() == k ) return ; 
        for( int i=next ; i<10 ; ++i ){
            cu.add( i ) ; 
            curr += i ; 
            backtrack( rs , n , k , curr , i+1 , cu ) ; 
            curr -= i ; 
            cu.removeLast() ; 
        }
    }
}