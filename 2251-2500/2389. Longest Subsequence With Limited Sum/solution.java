class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort( nums ) ; 
        int n = nums.length ; 
        int m = queries.length ; 
        int[] rs = new int[m] ;

        for(int i=1 ; i<n ;++i){
            nums[i] += nums[i-1] ; 
        } 
        for(int i=0 ; i<m ; ++i){
            int pos = Arrays.binarySearch( nums , queries[i] ) ; 
            if( pos >= 0  ){
                rs[i] = pos +1 ; 
            }else {
                rs[i] = -(pos+1) ; 
            }
        }
        return rs ;
    }
}