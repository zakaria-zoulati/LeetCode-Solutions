class Solution {
    public String answerString(String word, int m) {
        if(m == 1) return word;
        char max = ' ';
        String ans = "";
        for( char c : word.toCharArray() ){
            if( c > max ){
                max = c ; 
            }
        }
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == max) {
                String temp = word.substring(i, Math.min(word.length(), i + word.length() - (m - 1)));
                if(temp.compareTo(ans) > 0) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
}