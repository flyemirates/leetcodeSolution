public class Solution {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(str == null)
            return 0;
        // get rid of zeros
        String nonSpace = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                nonSpace = str.substring(i);
                break;
            }
        }
        if(nonSpace.length() == 0)
            return 0;
        String num = "";
        boolean positive = true;
        if(nonSpace.charAt(0) == '-'){
            num = nonSpace.substring(1);
            positive = false;}
        else if(nonSpace.charAt(0) == '+')
            num = nonSpace.substring(1);
        else
            num = nonSpace;
        int result = 0;
        int bord = (Integer.MAX_VALUE) / 10;
        for(int i = 0; i < num.length(); i++){
            char cur = num.charAt(i);
            if(cur < '0' || cur > '9')
                break;
            int change = (int)(cur - '0');
            if(result ==  bord && change >= 8 || (result > bord)){  // pay attention to the MAX, MIN number
                if(!positive)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;        
            }
            int new_res = result * 10 + change;
            if(new_res < 0){
                result = Integer.MAX_VALUE;
                break;
            }
            result = new_res;
        }
        
        if(positive)
            return result;
       
        return -result;
    }
}