class Solution {
    public String getStr( int n , int inter ){
        StringBuilder rs = new StringBuilder() ; 
        while( n!= 0 ){
            rs.append( n&1) ; 
            n >>= 1;
        }
        while( rs.length() < inter  ){
            rs.append(0)  ;
        }
        return rs.reverse().toString() ;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>() ;
        int n = nums.length ;
        int inter = 1 << n ;  
        for( int i= 0 ; i <inter ; ++i ){
            List<Integer> element  = new ArrayList<>() ; 
            String rep =  getStr(i,n) ;
            for(int j=0; j<n ; ++j){
                if( rep.charAt(j) == '1'  ){
                    element.add(nums[j] ) ; 
                }
            }
            rs.add( element );
        }
        return rs ; 
    }
}