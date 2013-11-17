public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length() == 0)
            return b;
        if(b.length() == 0)
            return a;
        char lasta = a.charAt(a.length() - 1);
        char lastb = b.charAt(b.length() - 1);
        String suba = a.substring(0, a.length() - 1);
        String subb = b.substring(0, b.length() - 1);
        if(lasta == '1' && lastb == '1'){
            
            return addBinary("1", addBinary(suba, subb)) + '0';
        }
        else{
            String sum = null;
            if(lasta != lastb)
                sum = "1";
            else
                sum = "0";
            return addBinary(suba, subb) + sum;
        }
    }
}