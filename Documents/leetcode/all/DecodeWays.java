public class Solution {
    HashMap<String, Integer> buf = null;
    HashSet<String> diction = null;
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        buf = new HashMap<String, Integer>();
        diction = new HashSet<String>();
        for(int i = 1; i <= 26; i++)
            diction.add(i + "");
        if(s.equals("0"))
            return 0;
        if(s.length() < 2)
            return s.length();
        
        int res = helper(s);
        return res;
    }
    public int helper(String s){
        if(buf.containsKey(s))
            return buf.get(s);
        if(s.length() == 0)
            return 1;
        if(s.charAt(0) == '0'){
            buf.put(s, 0);
            return 0;
        }
        if(s.length() < 2)
            return 1;
        
        int sum = 0;
        String first = s.charAt(0) + "";
        if(diction.contains(first))
            sum = sum + helper(s.substring(1));
        String two = s.substring(0, 2);
        if(diction.contains(two))
            sum = sum + helper(s.substring(2));
        buf.put(s, sum);
        return sum;
    }
}