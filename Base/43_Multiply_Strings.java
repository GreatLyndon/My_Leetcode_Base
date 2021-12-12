class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int[] ans_array = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--)
            for (int j = length2 - 1; j >= 0; j--) {
                int addition = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                ans_array[i + j + 1] += addition;
                if(ans_array[i + j + 1] > 9)
                    cur(ans_array, i + j + 1);
            }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ans_array.length; i++)
            ans.append(ans_array[i]);
        if (ans.charAt(0) == '0')
            return ans.substring(1).toString();
        return ans.toString();
    }

    private void cur(int[] ary, int index) {
        int preceding = ary[index] / 10;
        ary[index] %= 10;
        ary[index - 1] += preceding;
        if(ary[index - 1] > 10)
            cur(ary, index - 1);
    }
}
