class ProductOfNumbers {
    int in ; 
    int[] comp ;
    public ProductOfNumbers() {
        this.in = 0 ; 
        this.comp = new int[40_001] ; 
        comp[0] = 1 ; 
    }
    public void add(int num) {
        if( num == 0 ){
            in = 0 ; 
        }else {
            comp[++in] = comp[in-1]*num ; 
        }
    }
    public int getProduct(int k) {
        if( k > in ){
            return 0 ; 
        }else {
            return comp[in]/comp[in-k] ; 
        }
    }
}

