package cricketiplanalyser;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    public static final String IPL_RUN_CSV_FILE="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    public static final String IPL_WICKET_CSV_FILE="./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
    private HashMap<String, IPLDAO> map;

    public void  create() {
        this.map = new HashMap<>();
        this.map.put("player1", new IPLDAO("abc", 144, 23.5));
        this.map.put("player2", new IPLDAO("xyz", 143, 24.5));
        this.map.put("player3", new IPLDAO("lmn", 153, 27.5));
        this.map.put("player4",new IPLDAO("opq",290,23.89));
    }

    @Test
    public void GivenIPLRunsData_WhenCorrect_ShouldReturnRecord() {
        IPLAdapter iplAdapter = mock(IPLAdapterFactory.getIPLPlayer(CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS).getClass());
        try {
            create();
            when(iplAdapter.loadIPLCSVData(CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS,IPL_RUN_CSV_FILE)).thenReturn(this.map);
            CricketAnalyser cricketAnalyser=new CricketAnalyser();
            cricketAnalyser.setIplAdapter(iplAdapter);
            int size=cricketAnalyser.loadIPLCSVData(CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS,IPL_RUN_CSV_FILE);
            Assert.assertEquals(4,size);
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void GivenIPLwicketData_WhenCorrect_ShouldReturnRecord() {
        IPLAdapter iplAdapter = mock(IPLAdapterFactory.getIPLPlayer(CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS).getClass());
        try {
            create();
            when(iplAdapter.loadIPLCSVData(CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS,IPL_WICKET_CSV_FILE)).thenReturn(this.map);
            CricketAnalyser cricketAnalyser=new CricketAnalyser();
            cricketAnalyser.setIplAdapter(iplAdapter);
            int size = cricketAnalyser.loadIPLCSVData(CricketAnalyser.PlayerType.IPL_BOWLER_WICKETS,IPL_WICKET_CSV_FILE);
            Assert.assertEquals(4,size);
        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }
}
