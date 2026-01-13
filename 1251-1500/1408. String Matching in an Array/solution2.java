class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        ArrayList<String> s=new ArrayList<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i!=j && words[j].indexOf(words[i])!=-1){
                    s.add(words[i]);
                    break;
                }
            }
        }
        return s;
    }
}