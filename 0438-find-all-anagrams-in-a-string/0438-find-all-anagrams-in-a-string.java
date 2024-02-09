class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        int m = s.length();
        int n = p.length();
        int match = 0;
        for (int i = 0; i < m; i++) {
            //in
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                int count  = map.get(c);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(c, count);
            }
            
            //out
            if (i >= n) {
                Character out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    int count  = map.get(out);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(out, count);

                }
            }
            if(match == map.size()) {
                result.add(i - n + 1);
            }
        }
        
        return result;
    }
}