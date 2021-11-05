class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i < haystackLength - needleLength + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)
                    && haystack.charAt(i + needleLength - 1) == needle.charAt(needleLength - 1)) {
                int matchedChars = 0;
                for (int j = 0; j < needleLength; j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        matchedChars++;
                    } else {
                        break;
                    }
                }

                if (matchedChars == needleLength) {
                    return i;
                }
            }
        }

        return -1;
    }
}
