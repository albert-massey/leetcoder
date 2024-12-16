class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // To keep track of the number of subarrays whose sum equals k.
        HashMap<Integer, Integer> map = new HashMap<>(); // A hashmap to store running sum frequencies.
        int rSum = 0; // Running sum to track the cumulative sum of elements.
        
        // Initialize the map with a base case: running sum 0 occurs once.
        // This helps to handle cases where a subarray starting from index 0 has a sum equal to k.
        map.put(0, 1);
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the running sum by adding the current element.
            rSum += nums[i];
            
            // Check if there exists a subarray with sum k.
            // If (rSum - k) exists in the map, it means there is a subarray ending at the current index with sum k.
            if (map.containsKey(rSum - k)) {
                count += map.get(rSum - k); // Add the frequency of (rSum - k) to the count.
            }
            
            // Update the frequency of the current running sum in the map.
            // If rSum exists in the map, increment its frequency; otherwise, add it with a frequency of 1.
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        
        return count; // Return the total count of subarrays with sum k.
    }
}