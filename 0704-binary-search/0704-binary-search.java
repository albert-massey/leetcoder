class Solution {
    public int search(int[] nums, int target) {
        if(target > nums[nums.length-1] || target < nums[0]) return -1;
        return binarySearch(0, nums.length, target, nums);
    }
    
    private int binarySearch(int left, int right, int target, int[] nums) {
        
        int low = left;
        int high = right;
        while (low <= high) {
            
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}