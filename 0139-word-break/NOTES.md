# for loop based recursion
​
try to fix it (just need memoization)
​
class Solution {
boolean flag;
public boolean wordBreak(String s, List<String> wordDict) {
HashSet<String> set = new HashSet<>();
for(String st: wordDict) {
set.add(st);
}
flag = false;
recurse(s, set, 0);
return flag;
}
private void recurse(String s, HashSet<String> set, int pivot) {
if(pivot == s.length()) {
flag = true;
return;
}
for(int i = pivot; i < s.length(); i++) {
String sub = s.substring(pivot, i+1);
if(set.contains(sub)) {
if(set.contains(s.substring(i+1, s.length()))) {
flag = true;
return;
}
recurse(s, set, i+1);
}
}
}
}