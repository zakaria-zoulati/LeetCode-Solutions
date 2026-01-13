class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int m = part.length();
        int index;
        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + m);
        }
        return sb.toString();
    }
}