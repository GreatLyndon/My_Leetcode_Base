class Solution {
    public String intToRoman(int num) {
        int[] a = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] b = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int index = 0;
        StringBuilder ans = new StringBuilder();

        while (num > 0) {
            if (num >= a[index]) {
                ans.append(b[index]);
                num -= a[index];
            } else
                index++;
        }

        return ans.toString();
    }
}
