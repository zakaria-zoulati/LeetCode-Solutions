class Solution {
    public int[] rearrangeBarcodes(int[] b) {
        int n = b.length ; 
        int[] f = new int[10_001] ; 
        for(int num:b){
            ++f[num] ; 
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,bb) -> bb[1] - a[1] 
        ); 
        for(int i=1;i<=10_000;++i){
            if(f[i]==0)continue;
            pq.add( new int[]{ i , f[i] } ) ; 
        }
        int[] fi = pq.poll() ; 
        b[0] = fi[0] ; 
        if( --fi[1]!=0 ){
            pq.add(fi) ; 
        }
        for(int i=1;i<n;++i){
            int[] c=pq.poll();
            if(b[i-1] != c[0]){
                b[i]=c[0];
                if(--c[1]!=0){
                    pq.add(c);
                }
            }else{
                int[] next = pq.poll(); 
                pq.add(c);
                b[i] = next[0];
                if(--next[1] != 0){
                    pq.add(next);
                }
            }
        }
        return b;
    }
}