package cricketiplanalyser;

import java.util.Comparator;

public class SortByMaximum4wAnd5w implements Comparator<IPLDAO> {

    @Override
    public int compare(IPLDAO iplDao1, IPLDAO iplDao2) {
        return ((iplDao1.fourWicket+ iplDao1.fiveWicket) -(iplDao2.fourWicket + iplDao2.fiveWicket));
    }
}
