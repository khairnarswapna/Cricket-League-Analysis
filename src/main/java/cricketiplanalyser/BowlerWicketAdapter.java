package cricketiplanalyser;

import java.util.Map;

public class BowlerWicketAdapter extends IPLAdapter {

    @Override
    public Map<String, IPLDAO> loadIPLCSVData(String csvFilePath) throws CricketAnalyserException {
        Map<String, IPLDAO> map = super.loadIPLCSVData(BowlerWicketCSV.class, csvFilePath);
        return map;
    }
}
