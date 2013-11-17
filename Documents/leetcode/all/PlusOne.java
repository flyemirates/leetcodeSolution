public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == 0)
                break;
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if(carry == 0)
            return digits;
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        for(int i = 1; i < result.length; i++)
            result[i] = digits[i - 1];
        return result;
    }
    
}