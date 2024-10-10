class Solution {
    public int totalHammingDistance(int[] a) {
        int ans=0,n=a.length;
        for(int i=0;i<32;++i) {
            int c=0;
            for(int j:a) c+=(j>>i)&1;
            ans+=c*(n-c);
        }
        return ans;
    }
}