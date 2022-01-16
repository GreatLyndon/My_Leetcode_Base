class Solution {
    public int jump(int[] nums) {
        int maxIcanReach = 0;
        int n = nums.length;
        if(n == 1)
            return 0;
        int min = 0, currEnd = 0;
        for(int i = 0; i < n - 1; i++){
            maxIcanReach = Math.max(maxIcanReach, nums[i] + i);
            if(i == currEnd){
                min++;
                currEnd = maxIcanReach;
            }
        }
        return min;
    }
}
