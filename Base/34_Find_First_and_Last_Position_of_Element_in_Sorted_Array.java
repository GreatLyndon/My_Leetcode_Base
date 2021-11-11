class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = -1;
        int lastPos = -1;
        int i = 0, j = nums.length - 1, mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (target == nums[mid]) {
                firstPos = mid;
                j = mid - 1;
            } else if (target > nums[mid])
                i = mid + 1;
            else
                j = mid - 1;
        }
        if (firstPos != -1) {
            i = 0;
            j = nums.length - 1;
            while (i <= j) {
                mid = i + (j - i) / 2;
                if (target == nums[mid]) {
                    lastPos = mid;
                    i = mid + 1;
                } else if (target > nums[mid])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }
        return new int[] { firstPos, lastPos };
    }
}
