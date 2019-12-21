package cricketiplanalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplCricketAnalyserTest {

    private static final String IPL2019_RUNS_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String DELIMETER_MISSING_IPL_MOST_RUN_FILE="./src/test/resources/delimeterMissingIPL2019MostRuns.csv";
    private static final String HEADER_MISSING_IPL_MOST_RUN_FILE="./src/test/resources/HeaderMissingIPL2019MostRun.csv";
    private static final String SAMPLE_IPL_CSV_FILE="./src/test/resources/sampleIPLData.csv";
    private static final String IPL2019_WICKET_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLRunsData_ShouldReturnExactCount() {

        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            int count = cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            Assert.assertEquals(100,count);
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }

   @Test
    public void givenIPLRunsData_WithWrongFile_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(WRONG_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

   @Test
    public void givenIPLRunsData_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(DELIMETER_MISSING_IPL_MOST_RUN_FILE,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

    @Test
    public void givenIPLRunsData_WithIncorrectHeader_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyserException.class);
            cricketAnalyser.loadIPLCSVData(HEADER_MISSING_IPL_MOST_RUN_FILE,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

    @Test
    public void givenIPLRunsData_IfSortedByBattingAverage_ShouldReturn_HighestBattingAverage_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.AVERAGE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

   @Test
    public void givenIPLRunsData_IfSortedByBattingAverage_ShouldReturn_LowestBattingAverage_Player() {
       try {
           CricketAnalyser cricketAnalyser = new CricketAnalyser();
           cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
           String sortedResult = cricketAnalyser.sortbyFields(SortByField.AVERAGE);
           BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
           Assert.assertEquals("Harpreet Brar", iplRuns[iplRuns.length - 1].playerName);
       } catch (CricketAnalyserException e) {
           Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
       }
   }

    @Test
    public void givenIPLRunsData_IfSortedByBattingWStrike_Rate_ShouldReturn_TopStriking_Rate_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.STRIKE_RATE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedByBattingWStrike_Rate_ShouldReturn_LowestStriking_Rate_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.STRIKE_RATE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Bhuvneshwar Kumar", iplRuns[iplRuns.length-1].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedBy_HitMaximum4sAnd6s_ShouldReturn_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.MAXIMUM_SIX_AND_FOUR);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Andre Russell", iplRuns[iplRuns.length-1].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedByPlayer_Hit_Minimum4sAnd6s_ShouldReturn_PlayerName() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.MAXIMUM_SIX_AND_FOUR);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Tim Southee", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedbestStrikingratewith_4sAnd6s_ShouldReturnPlayer() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.STRIKING_WITH_MAXIMUM_SIXS_AND_FOURS);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("Andre Russell", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedbestAvergagewith_bestStrikingratewith_ShouldReturnPlayer() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.AVERAGE_WITH_STRIKE_RATE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    @Test
    public void givenIPLRunsData_IfSortedMaximumRuns_WithBestAverage_ShouldReturnPlayer() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_RUNS_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.MAXIMUM_RUNS_WITH_BEST_AVERAGE);
            BatsManRunCSV[] iplRuns = new Gson().fromJson(sortedResult, BatsManRunCSV[].class);
            Assert.assertEquals("David Warner", iplRuns[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }

    }

    //bowler Testcase
    @Test
    public void givenIPLWicketData_ShouldReturnExactCount() {

        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            int playercount = cricketAnalyser.loadIPLCSVData(IPL2019_WICKET_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS);
            System.out.println(playercount);
            Assert.assertEquals(99,playercount);
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWicketData_IfSortedByBowlingAverage_ShouldReturn_TopBowlingAverage_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_WICKET_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.TOP_BOWLER_AVERAGE);
            BowlerWicketCSV[] iplwicket = new Gson().fromJson(sortedResult, BowlerWicketCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplwicket[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

    @Test
    public void givenIPLWicketData_IfSortedByBowlingStrikingRates_ShouldReturn_TopStriking_Player() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.loadIPLCSVData(IPL2019_WICKET_CSV_FILE_PATH,CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS);
            String sortedResult = cricketAnalyser.sortbyFields(SortByField.TOP_BOWLERS_STRIK_RATE);
            BowlerWicketCSV[] iplwicket = new Gson().fromJson(sortedResult, BowlerWicketCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplwicket[0].playerName);
        } catch ( CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE, e.type);
        }
    }

}

