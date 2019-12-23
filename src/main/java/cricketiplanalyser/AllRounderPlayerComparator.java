package cricketiplanalyser;

public class AllRounderPlayerComparator implements java.util.Comparator<IPLDAO> {
    @Override
    public int compare(IPLDAO ipldao1, IPLDAO ipldao2) {
        return ((ipldao1.runs*(ipldao1.wickets))- (ipldao2.runs*(ipldao2.wickets)));
    }
}
