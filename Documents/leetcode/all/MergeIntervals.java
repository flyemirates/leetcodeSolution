/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Interval[] arr = new Interval[intervals.size()];
        for(int i = 0; i < intervals.size(); i++)
            arr[i] = intervals.get(i);
        Arrays.sort(arr, new MyComp());
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return result;
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            Interval last = result.get(result.size() - 1);
            Interval cur = arr[i];
            if(cur.start > last.end){
                result.add(cur);
                continue;
            }
            if(cur.end > last.end)
                last.end = cur.end;
        }
        return result;
    }
}

class MyComp implements Comparator<Interval>{
    public int compare(Interval int1, Interval int2){
        if(int1.start < int2.start)
            return -1;
        if(int1.start == int2.start)
        {
            if(int1.end < int2.end)
                return -1;
            else
                return 1;
        }
        return 1;
    }
}