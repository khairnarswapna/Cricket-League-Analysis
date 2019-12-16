package cricketiplanalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Map;

public class IplCricketAnalyserTest {

    private static final String IPL2019_RUNS_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String DELIMETER_MISSING_IPL_MOST_RUN_FILE="./src/test/resources/delimeterMissingIPL2019MostRuns.csv";
    private static final String HEADER_MISSING_IPL_MOST_RUN_FILE="./src/test/resources/HeaderMissingIPL2019MostRun.csv";
    private static final String SAMPLE_IPL_CSV_FILE="./src/test/resources/sampleIPLData.csv";

    @Test
    public void givenIPLAnalyserData_ShouldReturnExactCount() {
        Map<String,BatsManRunCSV> map = null;
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            map = cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101,map.size());
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_WithWrongFile_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(WRONG_CSV_FILE_PATH);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(DELIMETER_MISSING_IPL_MOST_RUN_FILE);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_WithIncorrectHeader_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(HEADER_MISSING_IPL_MOST_RUN_FILE);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_IfSortedByBattingAverage_ShouldReturn_HighestBattingAverage_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(SAMPLE_IPL_CSV_FILE);
            String sortedResult = cricketAnalyser.sortbyFields(SortbyField.Field.AVERAGE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

   @Test
    public void givenIPLMostRunsData_IfSortedByBattingAverage_ShouldReturn_LowestBattingAverage_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(SAMPLE_IPL_CSV_FILE);
            String sortedResult = cricketAnalyser.sortbyFields(SortbyField.Field.AVERAGE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRuns[iplRuns.length-1].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }
}
