class Solution {
    public int findMaxLength(int[] nums) {
        // Edge case: If the array has only one element, return 0 as no valid subarray exists.
        if (nums.length == 1) return 0;

        int max = 0; // To store the maximum length of a contiguous subarray with equal 0s and 1s.
        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap to store the running sum and its first occurrence index.

        // Initialize the map with a base case: running sum 0 occurs at index -1.
        // This helps to handle cases where a subarray starting from index 0 has equal 0s and 1s.
        map.put(0, -1);

        int sum = 0; // Running sum to keep track of the difference between the count of 1s and 0s.

        // Iterate through the binary array.
        for (int i = 0; i < nums.length; i++) {
            // Update the running sum: subtract 1 for 0, add 1 for 1.
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // Check if the running sum has been seen before.
            if (!map.containsKey(sum)) {
                // If the running sum is new, store it along with the current index.
                map.put(sum, i);
            } else {
                // If the running sum already exists in the map, it means the subarray between
                // the previous occurrence of this sum and the current index has equal 0s and 1s.
                int diff = i - map.get(sum); // Calculate the length of this subarray.
                max = Math.max(max, diff); // Update the maximum length if this subarray is longer.
            }
        }

        return max; // Return the maximum length of such a subarray.
    }
}