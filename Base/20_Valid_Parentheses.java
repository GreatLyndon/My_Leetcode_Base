import java.util.Stack;

class Solution<ListNode> {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty() && (c == ')' || c == '}' || c == ']'))
                return false;
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' && stack.peek() == '(')
                stack.pop();
            else if (c == '}' && stack.peek() == '{')
                stack.pop();
            else if (c == ']' && stack.peek() == '[')
                stack.pop();
            else
                return false;
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
