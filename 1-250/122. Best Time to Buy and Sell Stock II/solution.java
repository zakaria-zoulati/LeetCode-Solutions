class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ; 
        int min = 0 ; 
        int max = 0 ; 
        boolean holded = false ;
        for(int i=0 ; i<n ; ){
            if( !holded ){
                min = nums[i] ; 
                max = nums[i] ; 
                holded = true ; 
                i++ ; 
            }else {
                if( nums[i] > max ){
                    max = nums[i] ; 
                    i++ ; 
                }else {
                    rs += max - min ; 
                    holded = false ; 
                }
            }
        }
        if( holded ){
            rs += max - min ; 
        }
        return rs ;
    }
}