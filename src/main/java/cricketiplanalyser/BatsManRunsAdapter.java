package cricketiplanalyser;

import java.util.Map;

public class BatsManRunsAdapter extends IPLAdapter{

    @Override
    public Map<String, IPLDAO> loadIPLCSVData(String csvFilePath) throws CricketAnalyserException {

        Map<String, IPLDAO> map = super.loadIPLCSVData(BatsManRunCSV.class, csvFilePath);
        return map;

    }

}
