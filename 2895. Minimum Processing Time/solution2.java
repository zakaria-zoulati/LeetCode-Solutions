class Solution {
    public int minProcessingTime(List<Integer> p, List<Integer> t) {
        Collections.sort(t);
        Collections.sort(p);
        int j=0 ; 
        int rs=0;
        for(int i=t.size()-1;i>=0;i-=4){
            int k=p.get(j)+t.get(i);
            ++j;
            if(k>rs)rs=k;
        }
        return rs;
    }
}