class Solution {
    public String removeDuplicates(String s) {
        char [] ch=s.toCharArray();
        int end=-1;
        for(char c:ch){
            if(end>=0 && ch[end]==c){
                end--;
            }
            else{
                ch[++end]=c;
            }
        }
        return new String(ch,0,end+1);
    }
}
