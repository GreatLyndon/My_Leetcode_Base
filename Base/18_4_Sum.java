import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target || left != j + 1 && nums[left] == nums[left - 1])
                        left++;
                    else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>(
                                Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ans.add(temp);
                        left++;
                        right--;
                    } else if (sum > target || right != nums.length - 1 && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return ans;
    }
}
