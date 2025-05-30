import java.util.PriorityQueue;

class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int min;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        min = 1;
    }
    public int popSmallest() {
        if( !pq.isEmpty() ){
            return pq.poll() ; 
        }else {
            return min++ ; 
        }
    }
    public void addBack(int num) {
       if( num < min && !pq.contains( num ) ){
            pq.add( num ) ; 
       }
    }
}
