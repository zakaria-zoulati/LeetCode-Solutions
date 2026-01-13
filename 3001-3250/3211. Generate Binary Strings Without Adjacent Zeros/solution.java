class Solution {
    public void fill(StringBuilder current, int n, List<String> rs) {
        if (current.length() == n) {
            rs.add(current.toString());
            return;
        }
        fill(new StringBuilder(current).append('1'), n, rs);
        if (current.charAt(current.length() - 1) != '0') {
            fill(new StringBuilder(current).append('0'), n, rs);
        }
    }

    public List<String> validStrings(int n) {
        List<String> rs = new ArrayList<>();
        fill(new StringBuilder("0"), n, rs);
        fill(new StringBuilder("1"), n, rs);
        return rs;
    }
}