class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Required unique characters count
        int required = tMap.size();

        // Sliding window pointers and other variables
        int left = 0, right = 0;
        int formed = 0; // Tracks how many characters meet the required frequency
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // {window length, left, right}

        // Expand the window using the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if the current character matches the required frequency
            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the result if the current window is smaller
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the leftmost character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++; // Move the left pointer inward
            }

            right++; // Expand the window to the right
        }

        // Return the smallest window or an empty string if no valid window exists
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}