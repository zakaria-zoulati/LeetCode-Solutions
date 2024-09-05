class Solution {
    int mod = ( (int) 1e9 ) + 7 ; 
    public int rev(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length ; 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            int inter = nums[i] - rev( nums[i] ) ; 
            int count = map.getOrDefault( inter , 0 ); 
            rs  = ( rs + count )%mod ; 
            map.put( inter , count+1 ) ; 
        }
        return rs  ;
    }
}