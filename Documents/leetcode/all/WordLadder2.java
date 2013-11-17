public class Solution {
    HashSet<String> visited;
    ArrayList<ArrayList<String>> result;
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> buffer = new HashSet<String>();
        HashMap<String, ArrayList<String>> backtrace = new HashMap<String, ArrayList<String>>();
        visited = new HashSet<String>();
        result = new ArrayList<ArrayList<String>>();
        ArrayList<String> dest = new ArrayList<String>();
        buffer.add(start);
        
        while(!buffer.isEmpty()){
            
            HashSet<String> next_level = new HashSet<String>();
            boolean flag = false;
            
            for(String current : buffer){
                
                if(missOne(current, end)){
                    flag = true;
                    dest.add(current);
                    
                }
                
            }
            if(flag)
                break;
            else
            {
                
            for(String current: buffer){
                
                if(!visited.contains(current)){
                    visited.add(current);
                    for(String s : getOneDistance(current, dict, buffer)){
                        if(backtrace.containsKey(s)){
                            ArrayList<String> prev = backtrace.get(s);
                            prev.add(current);
                        }
                        else{
                            ArrayList<String> prev = new ArrayList<String>();
                            prev.add(current);
                            backtrace.put(s, prev);
                        }
                            
                        
                        next_level.add(s);
                    }
                }
            }
            buffer = next_level;
            }
        }
       
        ArrayList<String> path = new ArrayList<String>();
        path.add(end);
        helper(dest, path, backtrace);
        reverse();
        return result;
    }
    public void reverse(){
        for(int i = 0; i < result.size(); i++){
            ArrayList<String> path = result.get(i);
            for(int start = 0, end = path.size() - 1; start < end; start++, end--){
                String temp = new String(path.get(start));
                path.set(start, path.get(end));
                path.set(end, temp);
            }
        }
    }
    public void helper(ArrayList<String> dest, ArrayList<String> temp, HashMap<String, ArrayList<String>> backtrace){
        for(int i = 0; i < dest.size(); i++){
            String cur = dest.get(i);
            if(!backtrace.containsKey(cur)){
                temp.add(cur);
                result.add(temp);
                return;
            }
            ArrayList<String> next = backtrace.get(cur);
            
            ArrayList<String> copy = (ArrayList<String>) temp.clone();
            copy.add(cur);
            helper(next, copy, backtrace);
            
        }
    }
    public boolean missOne(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(count == 2)
                return false;
            if(a.charAt(i) != b.charAt(i))
                count++;
                }
        return count == 1;
    }
    public Set<String> getOneDistance(String word, HashSet<String> dict, HashSet<String> next){
        Set<String> result = new HashSet<String>();
        for(int i = 0; i != word.length(); i++){
            char current = word.charAt(i);
            char[] array = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++){
                if(c != current){
                    array[i] = c;
                    String toAdd = String.valueOf(array);
                    if(dict.contains(toAdd) && !visited.contains(toAdd) && !next.contains(toAdd))
                        result.add(toAdd);
                }
            }
        }
        return result;
    }
}