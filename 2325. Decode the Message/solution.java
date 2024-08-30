class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        int curr = 0;  
        for (char c : key.toCharArray()) {
            if (c != ' ' && map[c - 'a'] == 0) { 
                map[c - 'a'] = (char) (curr + 'a');
                curr++;
            }
        }

        StringBuilder rs = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                rs.append(' ');
            } else {
                rs.append(map[c - 'a']);
            }
        }

        return rs.toString();
    }
}
