package cricketiplanalyser;

import java.util.Comparator;

public class SortByMaximum4SAnd6s implements Comparator<IPLDAO> {

    @Override
    public int compare(IPLDAO iplDao1, IPLDAO ipldao2) {
        return ((iplDao1.noOfSixes * 6) + (iplDao1.noOfFours * 4))-((ipldao2.noOfSixes* 6) + (ipldao2.noOfFours * 4));
    }
}
