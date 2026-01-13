class Solution {
    public long beautifulSubarrays(int[] nums) {
        long rs = 0 ; 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        map.put(0,1) ; 
        int curr = 0 ;
        for(int num : nums){
            curr ^= num ; 
            int count = map.getOrDefault( curr ,0 ) ; 
            rs += count ; 
            map.put( curr , count +1 ) ; 
        }
        return rs ; 
    }
}