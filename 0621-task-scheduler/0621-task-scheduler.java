/*

AAABBB 2

AB_AB_AB



*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int noMostFreqChar = 0;
        int maxFreq = -1;
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            // if(maxFreq < map.get(task)) {
            //     maxFreq = map.get(task);
            // }
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxFreq) {
                noMostFreqChar += 1;
            }
        }
        
        int partitions = maxFreq - 1;
        int available = partitions * (n - (noMostFreqChar - 1));
        int pending = tasks.length - (maxFreq * noMostFreqChar);
        int idle = Math.max(0, available - pending);
        return tasks.length+idle;
        
    }
}