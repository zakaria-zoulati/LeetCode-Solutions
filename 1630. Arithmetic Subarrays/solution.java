class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length ; 
        int m = l.length ; 
        List<Boolean> rs = new ArrayList<>() ; 
        ok:for(int i=0; i<m ; ++i){
            int min = Integer.MAX_VALUE  ;
            int max = Integer.MIN_VALUE  ; 
            for(int j=l[i] ; j<=r[i] ; ++j ){
                min = Math.min( nums[j] , min ) ; 
                max = Math.max( nums[j] , max ) ; 
            }
            if( ( max-min ) % ( r[i] - l[i]  ) != 0  ){
                rs.add( false ) ; 
                continue  ;
            }
            int k = ( max-min ) /( r[i] - l[i]  ) ; 
            if( k == 0 ){
                rs.add( true ) ; 
                continue ;
            }
            HashSet<Integer> set = new HashSet<>(); 
            for(int j=l[i] ; j<=r[i] ; ++j ){
                if( (nums[j] - min)%k != 0   ){
                    rs.add( false ) ; 
                    continue ok ; 
                }
                if( set.contains(  (nums[j] - min)/k  ) ){
                    rs.add( false ) ; 
                    continue ok ; 
                }
                set.add( (nums[j] - min)/k   ) ; 
            }

            rs.add( true ) ; 
        }

        return rs ;

    }
}