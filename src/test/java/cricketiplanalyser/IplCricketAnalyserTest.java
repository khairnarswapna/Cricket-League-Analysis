package cricketiplanalyser;

import censusanalyser.CensusAnalyser;
import censusanalyser.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplCricketAnalyserTest {

    private static final String IPL2019_RUNS_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
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

    @Test
    public void givenIPLAnalyserData_WithWrongFile_ShouldThrowException() {
        try {
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            cricketAnalyser.loadCSVData(WRONG_CSV_FILE_PATH);
        } catch (CricketAnalyserException e) {
            Assert.assertEquals(CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

}
