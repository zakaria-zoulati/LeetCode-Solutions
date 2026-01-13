class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        dfs(ls, s, sb, 0);
        return ls;
    }
    public void dfs(List<String> ls, String s, StringBuilder sb, int i) {
        if(i == s.length()) {
            ls.add(sb.toString());
            return;
        }
        char ch = s.charAt(i);
        if(Character.isLetter(ch)) {
            sb.setCharAt(i, Character.toLowerCase(ch));
            dfs(ls, s, sb, i+1);
            sb.setCharAt(i, Character.toUpperCase(ch));
            dfs(ls, s, sb, i+1);
            sb.setCharAt(i, ch);
        }
        else {
            dfs(ls, s, sb, i+1);
        }
    }
}