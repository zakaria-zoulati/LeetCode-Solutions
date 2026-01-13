class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            rows[i] = new StringBuilder();
        }
        int cu = 0;
        boolean flag = false;
        numRows-- ; 
        for (char c : s.toCharArray()) {
            rows[cu].append(c);
            if ( cu == 0 || cu == numRows ) {
                flag = !flag;
            }
            cu += flag ? 1 : -1;
        }
        StringBuilder rs = new StringBuilder();
        for (StringBuilder row : rows) {
            rs.append(row);
        }
        return rs.toString();
    }
}
