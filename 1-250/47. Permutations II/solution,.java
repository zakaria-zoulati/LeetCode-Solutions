class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length ; 
        List<List<Integer>> rs = new ArrayList<>() ; 
        int[] f = new int[21] ; 
        for( int i : nums ){
            f[i+10]++ ; 
        }
        backtrack( rs , 0 , n , f , new ArrayList<>() ) ; 
        return rs ; 
    }

    public void backtrack( List<List<Integer>> rs , int in , int n , int[] f , List<Integer> curr ){
        if( in == n ){
            rs.add( new ArrayList<>(curr) ) ; 
            return ; 
        }
        for( int i=0 ; i<21 ; ++i ){
            if( f[i] == 0 ) continue ; 
            f[i]-- ; 
            curr.add( i-10 ) ; 
            backtrack( rs , in+1 , n , f , curr ) ; 
            curr.removeLast() ; 
            f[i]++ ; 
        }
    }
}