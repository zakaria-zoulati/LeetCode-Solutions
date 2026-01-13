class Solution {
    public void backtrack( List< List<Integer> > list , int[] nums , boolean[] isSeen , List<Integer> curr  ){
        if( curr.size() == nums.length ){
            list.add( curr  ) ; 
            return  ;
        }
        int n = nums.length ; 
        for(int i=0 ; i<n ; ++i){
            if( isSeen[i] ) continue ; 
            isSeen[i] = true; 
            List<Integer> next = new ArrayList<>(curr) ; 
            next.add( nums[i] ) ; 
            backtrack( list , nums , isSeen , next ) ; 
            isSeen[i] = false ; 
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length ; 
        List<List<Integer>> list = new ArrayList<>() ; 
        boolean[] isSeen = new boolean[n] ;
        backtrack( list , nums , isSeen , new ArrayList<>()  ) ; 
        return list ;
    }
}