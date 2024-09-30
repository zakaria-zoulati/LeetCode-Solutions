class CustomStack {
    int maxSize ; 
    int curr = 0; 
    int[] arr ;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize ; 
        arr = new int[maxSize] ; 
    }
    public void push(int x) {
        if( curr == maxSize ){
            return ; 
        }
        arr[curr++] = x ; 
    }
    public int pop() {
        if( curr == 0 ) return -1 ; 
        return arr[ (curr--) - 1 ] ; 
    }
    public void increment(int k, int val) {
        int m = Math.min( k , curr ) ; 
        for(int i=0 ; i<m;++i ){
            arr[i] += val ;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */