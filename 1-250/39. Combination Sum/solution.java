class Solution {
    public void backtrack( int[] nums , int sum , int t  , List<List<Integer>> rs , List<Integer> curr ,  int index  ){
        if( sum == t ){
            rs.add( curr ) ; 
            return  ; 
        }
        else if( sum > t ){
            return ; 
        }else {
            for(int i = index ; i< nums.length ; ++i){
                List<Integer> next = new ArrayList<>(curr) ; 
                next.add( nums[i] ) ; 
                backtrack( nums , sum + nums[i] , t , rs , next , i ) ; 
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>() ; 
        for(int i = 0 ; i<candidates.length ; ++i ){
            List<Integer> curr = new ArrayList<>() ; 
            curr.add( candidates[i] ) ; 
            backtrack( candidates , candidates[i] , target , list , curr , i  ) ; 
        }
        return list ; 
    }
}