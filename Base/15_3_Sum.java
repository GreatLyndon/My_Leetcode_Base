import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                helper(nums, i, res);
            }
        }
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        int target = nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == -target) {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (right > left && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (nums[left] + nums[right] > -target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
