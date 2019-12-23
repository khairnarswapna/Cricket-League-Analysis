package cricketiplanalyser;

public class BestBattingAndBowling implements java.util.Comparator<IPLDAO> {
    @Override
    public int compare(IPLDAO ipldao1, IPLDAO ipldao2) {
        return (int) ((ipldao1.average-(1d/ipldao1.Bowler_Average))-(ipldao2.average-(1d/ipldao2.Bowler_Average)));
    }
}
