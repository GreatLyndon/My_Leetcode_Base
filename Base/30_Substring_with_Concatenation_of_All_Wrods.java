import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        int wl = words[0].length();
        int range = s.length() - wl * words.length + 1;
        if (wl > s.length())
            return ans;
        int[] count = new int[words.length];
        for (int i = 0; i < range; i++) {
            int index = i;
            String a = s.substring(index, index + wl);
            if (hit(a, words, count)) {
                do {
                    index += wl;
                    if (index > s.length() - wl)
                        break;
                    a = s.substring(index, index + wl);
                } while (mark(a, words, count));
                if (detect(count)) {
                    ans.add(i);
                    i += wl - 1;
                }
            }
            for (int j = 0; j < count.length; j++)
                count[j] = 0;
        }
        return ans;
    }

    private boolean hit(String s, String[] words, int[] count) {
        for (int i = 0; i < words.length; i++) {
            if (s.equals(words[i])) {
                count[i] = 1;
                return true;
            }
        }
        return false;
    }

    private boolean mark(String s, String[] words, int[] count) {
        for (int i = 0; i < words.length; i++) {
            if (count[i] == 0 && s.equals(words[i])) {
                count[i] = 1;
                return true;
            }
        }
        return false;
    }

    private boolean detect(int[] count) {
        for (int i = 0; i < count.length; i++)
            if (count[i] == 0)
                return false;
        return true;
    }
}
