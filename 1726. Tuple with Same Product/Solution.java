class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ;   
        Map<Integer,Integer> map = new HashMap<>() ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                int mul = nums[i]*nums[j] ; 
                int curr = map.getOrDefault( mul , 0 ) ; 
                rs += 8*curr  ;
                map.put( mul , curr +1 ) ; 
            }
        } 
        return rs  ;
    }
}