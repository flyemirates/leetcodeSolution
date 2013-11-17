// get rid of 000

public class Solution {
    ArrayList<String> result;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<String>();
        helper(s, 0, new ArrayList<Integer>());
        return result;
    }
    public void helper(String s, int p, ArrayList<Integer> temp){
        if(temp.size() > 4)
            return;
        if(p == s.length()){
            if(temp.size() == 4){
                StringBuilder r = new StringBuilder();
                r.append(temp.get(0));
                for(int i = 1; i < 4; i++){
                    r.append(".");
                    r.append(temp.get(i));
                }
                result.add(r.toString());
            }
            return;
        }
        for(int i = 1; i <= 3 && (p + i) <= s.length(); i++){
            String cut = s.substring(p, p + i);
            int num = Integer.parseInt(cut);
            
            if(num >= 0 && num <= 255){
                ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
                copy.add(num);
                helper(s, p + i, copy);
            }
            if(num == 0)      // get rid of the 00, 001 something
                break;
        }
    }
    
}