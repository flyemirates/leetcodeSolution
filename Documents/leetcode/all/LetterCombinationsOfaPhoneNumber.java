public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        for(int i = 0; i < digits.length(); i++){
            char cur = digits.charAt(i);
            String letters = helper(cur);
            if(letters.length() == 0)
                continue;
            
            ArrayList<String> temp = new ArrayList<String>();
            for(int j = 0; j < letters.length(); j++){
                char l = letters.charAt(j);
                for(int k = 0; k < result.size(); k++)
                    temp.add(result.get(k) + l);
            }

            result = temp;
        }
        return result;
    }
    public String helper(char a){
        switch(a){
            case '1':
                break;
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return "";
    }
}