// worth to practice again~


public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0 || A.length == 1)
            return;
        int zero = -1, one = -1;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                
                int temp = A[i];
                A[i] = A[zero + 1];
                A[zero + 1] = temp;
                zero++;
                
                if(zero > one){          // need to increase one
                    one++;
                }
               
            }
            if(A[i] == 1){             // you may get 1 by exchanging from zero + 1
                
                int temp = A[i];
                A[i] = A[one + 1];
                A[one + 1] = temp;
                one++;
            }
        }
    }
}