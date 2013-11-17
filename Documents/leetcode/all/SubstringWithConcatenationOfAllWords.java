public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++){
            if(hs.containsKey(L[i]))
                hs.put(L[i], hs.get(L[i]) + 1);
            else{
                hs.put(L[i], 1);
            }
        }
        int word_len = L[0].length();
        ArrayList<Integer> ali = new ArrayList<Integer>();
        for(int i = 0; (i + word_len * L.length) <= S.length(); i++){
            HashMap<String, Integer> copy = (HashMap<String, Integer>) hs.clone();
            boolean flag = true;
            for(int j = i; j < i + word_len * L.length; j += word_len){
                String cur = S.substring(j, j + word_len);
                if(copy.containsKey(cur))
                {
                    if(copy.get(cur) > 0){
                        copy.put(cur, copy.get(cur) - 1);
                    }
                    else{
                        flag = false;
                        break;}
                }
                else{
                    flag = false;
                    break;}
            }
            if(flag)
                ali.add(i);
        }
        return ali;
    }
}