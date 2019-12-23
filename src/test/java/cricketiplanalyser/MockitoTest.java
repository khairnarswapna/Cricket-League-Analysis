package cricketiplanalyser;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    public static final String IPL_CSV_FILE="./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Mock
    IPLAdapter iplAdapter;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Test
    public void givenIPLSampleData_shouldReturnCount() {

        try {

            Map<String,IPLDAO> iplMap= new HashMap<>();
            IPLDAO ipldao=new IPLDAO();
            iplMap.put("Hardik pandya",ipldao);
            iplMap.put("viratKohali",ipldao);
            iplMap.put("Rohit sharma",ipldao);

            IPLAdapter iplAdapter= mock(IPLAdapter.class);
            when(iplAdapter.loadIPLCSVData(BatsManRunCSV.class,IPL_CSV_FILE)).thenReturn(iplMap);
            Assert.assertEquals(3,iplMap.size());

        } catch (CricketAnalyserException e) {
            e.printStackTrace();
        }
    }
}
