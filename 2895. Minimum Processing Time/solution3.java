class Solution {
    public int minProcessingTime(List<Integer> p, List<Integer> t) {
        int n = p.size(); 
        int[] ap = new int[n]; 
        int[] at = new int[n*4]; 
        for(int i=0;i<n;++i){
            ap[i]=p.get(i); 
        }
        for(int i=0;i<4*n;++i){
            at[i]=t.get(i); 
        }
        Arrays.sort(ap); 
        Arrays.sort(at);
        int rs=0; 
        int m=4*n-1; 
        for(int i=0;i<n;++i){
            int curr = ap[i]+at[m - 4*i]; 
            if(curr>rs){
                rs=curr; 
            }
        }
        return rs ; 
    }
}