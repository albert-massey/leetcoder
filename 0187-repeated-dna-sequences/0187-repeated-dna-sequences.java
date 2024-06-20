class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resultList = new ArrayList<>();
        HashSet<String> resultSet = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(i >= 9) {
                String sub = s.substring(i-9, i+1);
                if(!set.contains(sub)) {
                    set.add(sub);
                } else {
                    resultSet.add(sub);
                }
            }
        }
        resultList = resultSet.stream().collect(Collectors.toList());

        return resultList;
    }
}