class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (c != 'B' && c != 'D') continue;
            boolean flag = true;
            while (stack.size() > 1 && flag) {
                char top = stack.pop();
                if (stack.peek() == 'A' && top == 'B') stack.pop();
                else if (stack.peek() == 'C' && top == 'D') stack.pop();
                else {
                    stack.push(top);
                    flag = false;
                }
            }
        }
        return stack.size();
    }
}