class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] origin = nums.clone() ; 
        int n =  nums.length ; 
        Arrays.sort( nums ) ; 
        int[] rs = new int[k] ; 
        HashMap< Integer , Integer > map = new HashMap<>() ; 
        for(int i=n-k ; i<n ; ++i){
            map.put( nums[i] , map.getOrDefault( nums[i] , 0 ) +1 ) ; 
        } 
        int curr = 0 ;
        for(int i=0 ; i<n ; ++i){
            if( map.get( origin[i] ) != null && map.get( origin[i] ) > 0  ){
                rs[ curr++ ] = origin[i] ; 
                map.put( origin[i] , map.get( origin[i] ) -1 ) ; 
            }
        }
        return rs  ;
        
    }
}