class Solution {
    public int halveArray(int[] nums) {
        double sum = 0; 
        int rs = 0 ; 
        PriorityQueue<Double> pq = new PriorityQueue<>(
           (a,b) -> Double.compare(b,a) 
        ); 
        for( int i : nums ){
            sum += i ; 
            pq.add( (double) i) ; 
        }
        double curr = 0 ; 
        sum /= 2 ; 
        while( curr < sum ){
            double e = pq.poll() ; 
            curr += e/2 ; 
            pq.add( e/2 ) ; 
            rs++ ; 
        }
        return rs ;
    }
}