public class solution {
    public int myAtoi(String s) {
        int index = 0;
        int positive = 1;
        int result = 0;

        while (index < s.length() && s.charAt(index) == ' ')
            index++;
        if (index < s.length() && s.charAt(index) == '+')
            index++;
        else if (index < s.length() && s.charAt(index) == '-') {
            index++;
            positive = 0;
        }
        while (index < s.length()) {
            char one = s.charAt(index++);
            if (one < '0' || one > '9')
                break;
            int nextone = Character.getNumericValue(one);
            if (positive == 1)
                if (result > Integer.MAX_VALUE / 10)
                    return Integer.MAX_VALUE;
                else if (result == Integer.MAX_VALUE / 10 && nextone >= 7)
                    return Integer.MAX_VALUE;
            if (positive == 0)
                if (result > Integer.MAX_VALUE / 10)
                    return Integer.MIN_VALUE;
                else if (result == Integer.MAX_VALUE / 10 && nextone >= 8)
                    return Integer.MIN_VALUE;

            result = result * 10 + nextone;
        }

        if (positive == 0)
            return -result;
        return result;
    }
}
