import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length(), words_num = words.length;
        List<Integer> ans = new LinkedList<>();
        if (len == 0 || words_num == 0)
            return ans;
        int one_word = words[0].length();
        HashMap<String, Integer> m1 = new HashMap<>();
        for (String word : words)
            m1.put(word, 1);

        for (int i = 0; i < one_word; i++) {
            int l = i;
            int r = i;
            int count = 0;
            HashMap<String, Integer> m2 = new HashMap<>();
            while (r + one_word <= len) {
                String tmp = s.substring(r, r + one_word);
                r += one_word;
                if (!m1.containsKey(tmp)) {
                    count = 0;
                    l = r;
                    m2.clear();
                } else {
                    if (m2.containsKey(tmp))
                        m2.put(tmp, m2.get(tmp) + 1);
                    else
                        m2.put(tmp, 1);
                    count++;
                    while (m2.get(tmp) > m1.get(tmp)) {
                        String tmp2 = s.substring(l, l + one_word);
                        l += one_word;
                        if (m2.containsKey(tmp2))
                            m2.put(tmp2, m2.get(tmp2) - 1);
                        count--;
                    }
                    if (count == words_num)
                        ans.add(l);
                }
            }
        }

        return ans;
    }
}
