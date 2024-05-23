class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        class Pair {
            int num;
            int freq;
            public Pair(int num, int freq) {
                this.num = num;
                this.freq = freq;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Pair pr = new Pair(entry.getKey(), entry.getValue());
        // System.out.println();
            pq.add(pr);
            if(pq.size() > k) {
                pq.poll();
            } 
        }
                    // System.out.println("size: "+pq.size());

        // map.forEach((key, value) -> System.out.printf("%-15s : %s%n", key, value));

        // while(!pq.isEmpty()){
        //     Pair prr = pq.poll();
        //     System.out.println("size: "+pq.size());
        //     System.out.println(prr.num + " "+prr.freq);
        //     result[i] = prr.num;
        //     i++;
        // }
        for(int i = k - 1; i >=0; i--) {
            Pair prr = pq.poll();
            result[i] = prr.num;
        }
        return result;
    }
}