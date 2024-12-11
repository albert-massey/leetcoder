class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> st = new Stack<>();
        
        for(String log: logs) {
            String[] splitLog = log.split(":");
            int functionId = Integer.parseInt(splitLog[0]);
            String startOrEnd = splitLog[1];
            int ts = Integer.parseInt(splitLog[2]);
            if (startOrEnd.equals("start")) {
                st.push(new int[]{functionId, ts});
            } else {
                int[] startInfo = st.pop();
                int startId = startInfo[0];
                int startTime = startInfo[1];
                int duration = ts - startTime + 1;
                result[startId] += duration;
                
                if(!st.isEmpty()) {
                    result[st.peek()[0]] -= duration;
                }
            }
        }
        return result;
    }
}