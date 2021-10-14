public class solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        
        StringBuilder result = new StringBuilder();
        int round = 2 * numRows - 2;

        for(int i = 0; i < numRows; i++)
            for(int j = 0; j < s.length(); j+= round) {
                result.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + round - i < s.length())
                    result.append(s.charAt(j + round - i));
            }
        
        return result.toString();
    }
}
