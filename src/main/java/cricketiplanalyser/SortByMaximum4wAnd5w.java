package cricketiplanalyser;

import java.util.Comparator;

public class SortByMaximum4wAnd5w implements Comparator<IPLDAO> {

    @Override
    public int compare(IPLDAO ipldao1, IPLDAO ipldao2) {

        return ((ipldao1.fourWicket+ ipldao1.fiveWicket) -(ipldao2.fourWicket + ipldao2.fiveWicket));
    }
}
