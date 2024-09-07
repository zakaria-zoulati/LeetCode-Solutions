class Solution {
    public String sortVowels(String s) {
        if(s.length()==1) return s;
        StringBuilder tem=new StringBuilder();
        String lc=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char in=lc.charAt(i);
            if(isVowel(in)){
                tem.append(s.charAt(i));
            }
        }
        char[] ch=tem.toString().toCharArray();
        Arrays.sort(ch);
        String sortedVowels=new String(ch);
        int e=0;
        StringBuilder ne=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char in=lc.charAt(i);
            if(!isVowel(in)){
                ne.append(s.charAt(i));
            }else{
                ne.append(sortedVowels.charAt(e));
                e++;
            }
        }

        return ne.toString();
    }

    private boolean isVowel(char c) {
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}