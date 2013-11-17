public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int sign = 1;
        int a = (dividend >> 31) & 1;
        int b = (divisor >> 31) & 1;
        if((a ^ b) == 1)
            sign = -1;
        long dend = (dividend > 0) ? dividend : -((long)dividend);
        long sor = (divisor > 0) ? divisor : -((long)divisor);
        if(dend == sor)
            return sign;
        if(dend < sor)
            return 0;
        if(dend == 0)
            return 0;
        if(sor == 1)
        {
            if(sign == 1)
                return (int)dend;
            else
                return (int)-dend;
        }
        int result = 0;
        long temp = sor;
        long[] buf = new long[32];
        int i = 0;
        for(; dend > temp; i++){
            buf[i] = temp;
            if(temp < 0)
                break;
            temp = temp << 1;
        }
        i--;
        while(dend > 0 && dend > sor){
            if(dend >= buf[i]){
                result += 1 << i;
                dend = dend - buf[i];
            }
            else
                i--;
        }
        if(sign == 1)
            return result;
        else
            return -result;
    }
}