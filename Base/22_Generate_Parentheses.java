import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        char[] s = new char[n * 2];
        insertOne(ans, n, 0, 0, s);
        return ans;
    }

    private void insertOne(List<String> ans, int n, int left, int right, char[] s) {
        if (left < n) {
            s[left + right] = '(';
            insertOne(ans, n, left + 1, right, s);
        }
        if (left > right) {
            s[left + right] = ')';
            insertOne(ans, n, left, right + 1, s);
        }
        if (left + right == 2 * n)
            ans.add(new String(s));
    }
}
