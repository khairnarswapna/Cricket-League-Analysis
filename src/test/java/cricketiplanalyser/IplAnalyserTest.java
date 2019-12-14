package cricketiplanalyser;

import org.junit.Assert;
import org.junit.Test;

public class IplAnalyserTest {

    private static final String IPL2019_RUNS_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenLeagueMostRunDataCSVFile_ShouldReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        int totalRecord = cricketAnalyser.readCSVData(IPL2019_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(101,totalRecord);
    }

}
