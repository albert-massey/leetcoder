class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        HashMap<Character, Integer> map = new HashMap<>();
        int noMostFreqChar = 0; // Number of tasks with maximum frequency
        int maxFreq = -1; // Maximum frequency of any task
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        
        // Step 2: Count how many tasks have the maximum frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                noMostFreqChar += 1;
            }
        }
        
        // Step 3: Calculate the partitions and available slots
        int partitions = maxFreq - 1; // Number of gaps between the most frequent tasks
        int available = partitions * (n - (noMostFreqChar - 1)); // Total available slots for other tasks
        
        // Step 4: Calculate the pending tasks
        int pending = tasks.length - (maxFreq * noMostFreqChar); // Remaining tasks to be scheduled
        
        // Step 5: Calculate idle intervals
        int idle = Math.max(0, available - pending); // Idle slots needed
        
        // Step 6: Total intervals = tasks + idle slots
        return tasks.length + idle;
    }
}