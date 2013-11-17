public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++){
            String coded = code(strs[i]);
            if(!hm.containsKey(coded)){
                ArrayList<String> als = new ArrayList<String>();
                als.add(strs[i]);
                hm.put(coded, als);
            }
            else{
                ArrayList<String> temp = hm.get(coded);
                temp.add(strs[i]);
                hm.put(coded, temp);
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        for(String i : hm.keySet()){
            if(hm.get(i).size() > 1){
                for(int p = 0; p < hm.get(i).size(); p++){
                    result.add(hm.get(i).get(p));
                }
            }
        }
        return result;
    }
    public String code(String a){
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        String result = new String(chars);
        return result;
    }
}