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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i = 0;
        for(; i < intervals.size(); i++){
            if(intervals.get(i).start < newInterval.start){
                result.add(intervals.get(i));
            }
            else{
                if(result.size() == 0){
                    result.add(newInterval);
                    break;
                }
                Interval last = result.get(result.size() - 1);
                if(last.end >= newInterval.start){
                    last.end = Math.max(last.end, newInterval.end);
                }
                else{
                    result.add(newInterval);
                }
                break;
            }
        }
        if(i == intervals.size()){
            Interval last = result.get(result.size() - 1);
            if(last.end >= newInterval.start){
                    last.end = Math.max(last.end, newInterval.end);
                }
                else{
                    result.add(newInterval);
                }
            return result;
        }
        for(; i < intervals.size(); i++){
            Interval last = result.get(result.size() - 1);
            if(intervals.get(i).start <= last.end){
                last.end = Math.max(last.end, intervals.get(i).end);
            }
            else
                result.add(intervals.get(i));
        }
        return result;
    }
}
