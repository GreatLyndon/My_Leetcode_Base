import java.util.HashMap;

public class solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] c = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            int temp = target - nums[i];
            if(map.size() != 0 && map.containsKey(nums[i]))
                {
                    c[0] = map.get(nums[i]);
                    c[1] = i;
                }
            else
                map.put(temp, i);
        }
        return c;
    }
}
