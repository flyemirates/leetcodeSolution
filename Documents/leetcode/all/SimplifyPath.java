// so many corner case

public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> als = new ArrayList<String>();
        if(path.length() < 2)
            return path;
        int start = 0;
        int end = 1;
        for(; end < path.length(); end++){
            if(path.charAt(end) == '/'){
                if(end == start + 1)
                {    
                    start = end;
                    continue;
                }
                als.add(path.substring(start + 1, end));
                start = end;
            }
        }
        if(path.charAt(end - 1) != '/')   // path may not end with '/'
            als.add(path.substring(start + 1));
        int size = als.size();
        for(int i = 0; i < size; i++){
            if(als.get(i).equals(".")){
                als.remove(i);
                i--;
                size--;
                continue;
            }
            if(als.get(i).equals("..")){
                als.remove(i);
                size--;
                
                if(i != 0){
                    als.remove(i - 1);
                    size--;
                    i = i - 2;
                }
                else   // if i == 0, i need to self deduce;
                    i--;
            }

        }
        String result = "";
        for(int i = 0; i < size; i++){
            result = result + "/";
            result = result + als.get(i);
        }
        if(result.length() == 0)  // 
            return "/";
        return result;
    }
}