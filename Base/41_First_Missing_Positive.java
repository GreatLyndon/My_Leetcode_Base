class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if ((nums[i] <= 0) || (nums[i] > length) || (nums[nums[i] - 1] == nums[i]))
                i++;
            else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        int result = 1;
        for (int j = 0; j < length; j++) {
            if (nums[j] == result)
                result++;
            else
                break;
        }
        return result;
    }
}
