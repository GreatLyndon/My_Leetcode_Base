class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String string = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char current = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (current == string.charAt(i)) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(current);
                count = 1;
                current = string.charAt(i);
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(current);
        return stringBuilder.toString();
    }
}
