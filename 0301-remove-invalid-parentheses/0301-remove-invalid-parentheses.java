class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            for(int j = 0; j < q.size(); j++) {
                String currStr = q.poll();
                if(isValid(currStr)) {
                    found = true;
                    result.add(currStr);
                }
                if(!found) {
                    for(int i = 0; i < currStr.length(); i++) {
                        char c = currStr.charAt(i);
                        if(!Character.isAlphabetic(c)) {
                            String childStr = currStr.substring(0, i) + currStr.substring(i+1);
                            if(!set.contains(childStr)) {
                                set.add(childStr); q.add(childStr);
                            }
                        }
                    }
                }
            }
        }
        if(result.size() == 0) {
            result.add("");
        }
        if(s.length() == 0) {
            result.add("");
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            if(count < 0) return false;
        }
        return count == 0;
    }
}