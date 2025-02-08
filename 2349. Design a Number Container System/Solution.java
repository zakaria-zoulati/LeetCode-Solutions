class NumberContainers {
    Map<Integer,Integer> indexes ;
    Map<Integer,PriorityQueue<Integer> > numbers ; 
    public NumberContainers() { 
        indexes = new HashMap<>() ;
        numbers = new HashMap<>() ; 
    }
    public void change(int index, int number) {
        indexes.put( index , number ) ; 
        PriorityQueue<Integer> pq = numbers.get(number) ; 
        if( pq == null ){
            numbers.put(number , pq = new PriorityQueue<>() ) ; 
        }
        pq.add(index) ; 
    }
    public int find(int number) {
        PriorityQueue<Integer> pq = numbers.get(number) ; 
        if( pq == null ){
            return -1 ; 
        }
        while( !pq.isEmpty() ){
            int curr = pq.peek() ; 
            if( indexes.get(curr) == number ){
                return curr ; 
            }else {
               pq.poll() ; 
            }
        }
        return -1 ;
    }
}
