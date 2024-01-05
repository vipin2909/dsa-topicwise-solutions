import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {
    public Interval[] merge(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        ArrayList<Interval> list = new ArrayList<>();
        Interval newInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start > newInterval.end) {
                list.add(newInterval);
                newInterval = intervals[i];
            }
            else if(intervals[i].start < newInterval.end) {
                newInterval.end = Math.max(newInterval.end, intervals[i].end);
            }
        }

        list.add(newInterval);

        Interval[] result = new Interval[list.size()];
        int k = 0;
        for(Interval i: list) {
            result[k++] = i;
        }
        return result;
    }
}
