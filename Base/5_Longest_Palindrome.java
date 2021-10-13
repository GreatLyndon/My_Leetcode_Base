public class solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int long1 = testp(s, i, i);
            int long2 = testp(s, i, i + 1);
            int max = Math.max(long1, long2);
            if(max > right - left)
            {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    private int testp(String s, int left, int right) {
        int l = left, r = right;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }
        
        return r - l - 1;
    }
}
