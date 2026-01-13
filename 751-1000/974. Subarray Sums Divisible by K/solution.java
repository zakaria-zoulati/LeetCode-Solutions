import java.util.HashMap ; 
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length ; 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        int rs = 0 ;
        nums[0] = ( 10000*k + nums[0] ) % k  ; 
        if( nums[0]  == 0  ){
            rs++ ; 
            map.put( 0 , 2 ) ; 
        }else {
            map.put( 0 , 1 ) ; 
            map.put( nums[0] , 1 ) ;
        }
        for(int i=1 ; i<n ; ++i){
            nums[i] = ( nums[i] + nums[i-1] + 10000*k ) % k ; 
            int count = map.getOrDefault( nums[i] , 0 ) ;
            rs += count ;
            map.put( nums[i] , count + 1 ) ;
        }
        return rs ; 
    }
}