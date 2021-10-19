class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int temp = height[left] > height[right] ? height[right] * (right - left) : height[left] * (right - left);
            max = temp > max ? temp : max;

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
