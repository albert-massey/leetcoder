class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result  = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr-1] > 0) {
                nums[curr-1] = nums[curr-1] * -1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}