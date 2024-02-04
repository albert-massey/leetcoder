class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //a = [5, 15]
        //b = [10, 20]
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // int[] interval = intervals[i];
            if(intervals[i][0] >= pq.peek())  {
                pq.poll();
                pq.add(intervals[i][1]);
            } else {
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}