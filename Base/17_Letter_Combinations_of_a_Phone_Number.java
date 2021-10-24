class Solution {
    char[][] map = new char[][]{{},{},
                                {'a','b','c'},
                                {'d','e','f'},
                                {'g','h','i'},
                                {'j','k','l'},
                                {'m','n','o'},
                                {'p','q','r','s'},
                                {'t','u','v'},
                                {'w','x','y','z'}};
    
    private void comb(String digits, int idx, char[] str, List<String> res) {
        if (idx == digits.length()) {
            res.add(new String(str));
            return;
        }
        int d = digits.charAt(idx)-'0';
        
        char[] chs = map[d];
        
        for(char c : chs) {
            str[idx] = c;
            comb(digits, idx+1, str, res);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        char[] str = new char[digits.length()];
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        comb(digits, 0, str, res);
        return res;
    }
}
