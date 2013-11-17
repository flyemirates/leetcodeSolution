public class Solution {
 public String multiply(String num1, String num2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] result = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            int one = num1.charAt(i) - '0';
            int carry = 0;
            if(one == 0)
                continue;
            for(int j = num2.length() - 1; j >= 0; j--){
                int two = num2.charAt(j) - '0';
                int multi = one * two;
                int cur = result[i + j + 1] + multi + carry;
                result[i + j + 1] = cur % 10;
                carry = cur / 10;
            }
            if(carry > 0)
                result[i] += carry;
        }
        String res = "";
        int i = 0;
        while(i < result.length && result[i] == 0 )
            i++;
        for(; i < result.length; i++)
            res = res + (char)('0' + result[i]);
        if(res.length() == 0)
        	return "0";
        return new String(res);
    }
}