import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int index = s.length() - 1;
        int ans = map.get(s.charAt(index--));
        
        while(index >= 0) {
            if(map.get(s.charAt(index)) >= map.get(s.charAt(index + 1)))
                ans += map.get(s.charAt(index));
            else
                ans -= map.get(s.charAt(index));
            index--;
        }

        return ans;
    }
}
}
