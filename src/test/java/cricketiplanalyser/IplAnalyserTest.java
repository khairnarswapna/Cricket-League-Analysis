package cricketiplanalyser;

import org.junit.Assert;
import org.junit.Test;

public class IplAnalyserTest {

    private static final String IPL2019_RUNS_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenLeagueMostRunDataCSVFile_ShouldReturnExactCount() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            int totalRecord = cricketAnalyser.loadCSVData(IPL2019_RUNS_CSV_FILE_PATH);
            System.out.println(totalRecord);
            Assert.assertEquals(101,totalRecord);
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }

}
