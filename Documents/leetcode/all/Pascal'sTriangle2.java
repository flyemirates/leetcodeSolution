public class Solution {
    
    public ArrayList<Integer> getRow(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(numRows < 0)
            return new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        numRows--;
        while(numRows >= 0){
            ArrayList<Integer> next = new ArrayList<Integer>();
            next.add(1);
            for(int i = 1; i < temp.size(); i++)
            {
                int sum = temp.get(i - 1) + temp.get(i);
                next.add(sum);
            }
            next.add(1);
            temp = next;
            numRows--;
        }
        return temp;
    }
 
}