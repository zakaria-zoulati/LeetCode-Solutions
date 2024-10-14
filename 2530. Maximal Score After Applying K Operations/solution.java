class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (a,b) -> b - a
        ) ; 
        long rs = 0L ; 
        for(int num : nums){
            q.add( num ) ; 
        }
        while( k-- > 0 ){
            int curr = q.poll() ; 
            rs += curr ; 
            q.add( curr/3 + ( curr % 3 != 0 ? 1 : 0 ) ) ; 
        }
        return rs ; 
    }
}