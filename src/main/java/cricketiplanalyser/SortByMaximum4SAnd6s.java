package cricketiplanalyser;

import java.util.Comparator;

public class SortByMaximum4SAnd6s implements Comparator<BatsManRunCSV> {
    @Override
    public int compare(BatsManRunCSV batsManRunCSV1, BatsManRunCSV batsManRunCSV2) {
        return ((batsManRunCSV1.noOfSixes * 6) + (batsManRunCSV1.noOfFours * 4))-((batsManRunCSV2.noOfSixes* 6) + (batsManRunCSV2.noOfFours * 4));
    }

}
