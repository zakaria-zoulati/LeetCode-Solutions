class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long rs = 0 ; 
        int current  = nums.get(0) ; 
        int index =  0 ;
        int n  =  nums.size() ; 
        for(int i=1; i<n ; ++i){
            if( nums.get(i) > current  ){
                rs += current ;  
                current = nums.get(i) ; 
                index = i ; 
            }else {
                rs += current ; 
            }
        }
        return rs ; 
    }
}