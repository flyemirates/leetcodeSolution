public class Solution {
    HashSet<String> visited;
    LinkedList<Pair> queue;
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        visited = new HashSet<String>();
        if(start.equals(end))
            return 1;
        if(dict.isEmpty())
            return 0;
        queue = new LinkedList<Pair>();
        dict.add(start);
        dict.add(end);
        missOne(2, start, dict);
        visited.add(start);
        while(!queue.isEmpty()){
            
            Pair cur = queue.remove(0);
            if(cur.str.equals(end))
                return cur.level;
            if(visited.contains(cur.str))
                continue;
            visited.add(cur.str);
            if(visited.size() == dict.size())
                return 0;
            missOne(cur.level + 1, cur.str, dict);
        }
        return 0;
        
    }
    public void missOne(int lev, String a, HashSet<String> dict){
        char[] array = a.toCharArray();
        for(int i = 0; i < array.length; i++){
            char c = array[i];
            for(char j = 'a'; j <= 'z'; j++){
                
                if(j == c)
                    continue;
                array[i] = j;
                String change = new String(array);
                if(!dict.contains(change) || visited.contains(change))
                    continue;
                Pair p = new Pair(change, lev);
                queue.add(p);
            }
            array[i] = c;
        }
        
    }
}

class Pair{
    int level;
    String str;
    Pair(String s, int l){
        this.level = l;
        this.str = s;
    }
}