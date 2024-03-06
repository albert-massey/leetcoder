class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return result;
        }       
        
        
        
        for(String str: strs) {
            char[] charray = str.toCharArray();
            Arrays.sort(charray);
            String sortedStr = new String(charray);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(str);
            } else {
                map.get(sortedStr).add(str);                
            }
        }
        
        map.forEach((key, value) -> {
            result.add(value);
        });

        return result;
        
    }
}

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> result = new ArrayList<>();
//         if(strs == null || strs.length == 0) {
//             return result;
//         }
//         HashMap<Long, List<String>> map = new HashMap<>();
//         int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
// 				101 };
//         for(String str: strs) {
//             long prod = 1;
//             for(int i = 0; i < str.length(); i++){
//                 char c = str.charAt(i);
//                 prod = prod * Long.valueOf(primes[c - 'a']);
//             }
//             if(!map.containsKey(prod)) {
//                 map.put(prod, new ArrayList<>());
//                 map.get(prod).add(str);
//             } else {
//                 map.get(prod).add(str);                
//             }
//         }
        
//         map.forEach((key, value) -> {
//             result.add(value);
//         });

//         return result;
//     }
// }