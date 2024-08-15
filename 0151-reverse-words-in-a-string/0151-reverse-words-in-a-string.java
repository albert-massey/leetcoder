class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] sArray = s.split("\\s+");
        for(int i = sArray.length -1; i >= 0; i--) {
            System.out.println(sArray[i]);
            sb.append(sArray[i]);
            if(i != 0) sb.append(" ");
        }
        return sb.toString().trim();
    }
}