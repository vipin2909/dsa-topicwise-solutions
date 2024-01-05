import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "["+start+", "+end+"]";
    }
}


public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<>();
        Collections.sort(intervals, new CustComp());

        for(int i = 0; i < intervals.size(); i += 1) {
            if(intervals.get(i).end < newInterval.start) {
                list.add(intervals.get(i));
            }
            else if(intervals.get(i).start > newInterval.end) {
                list.add(newInterval);
                for(int j = i; j < intervals.size(); j++) {
                    list.add(intervals.get(j));
                }
                return list;
            }
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        list.add(newInterval);
        return list;
    
    }
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> result = mergeIntervals.insert(list, newInterval);
        for(Interval i: result) {
            System.out.println(i);
        }

    }   
}

class CustComp implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}