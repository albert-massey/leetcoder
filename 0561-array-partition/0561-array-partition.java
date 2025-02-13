class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;
        while(i <= nums.length-2) {
            sum += Math.min(nums[i], nums[i+1]);
            i += 2;
        }
        return sum;
    }
}