package cricketiplanalyser;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyser {


    public enum PlayerType{ IPL_BATSMAN_RUNS, IPL_BOWLER_WICKETS }

    Map<String, IPLDAO> iplCsvMap = new HashMap<>();
    Map<SortByField, Comparator<IPLDAO>> fieldComparatorMap= null;
    public CricketAnalyser() {
            iplCsvMap = new HashMap<>();
            fieldComparatorMap= new HashMap<>();
            fieldComparatorMap.put(SortByField.AVERAGE, Comparator.comparing(field-> field.average, Comparator.reverseOrder()));
            fieldComparatorMap.put(SortByField.STRIKE_RATE,Comparator.comparing(field-> field.strikeRate, Comparator.reverseOrder()));
            fieldComparatorMap.put(SortByField.MAXIMUM_SIX_AND_FOUR,new SortByMaximum4SAnd6s());
            fieldComparatorMap.put(SortByField.STRIKING_WITH_MAXIMUM_SIXS_AND_FOURS, new SortByMaximum4SAnd6s().reversed().thenComparing(field -> field.strikeRate));
            Comparator<IPLDAO> comparator = Comparator.comparing(field -> field.average);
            fieldComparatorMap.put(SortByField.AVERAGE_WITH_STRIKE_RATE, comparator.thenComparing(field-> field.strikeRate).reversed());
            Comparator<IPLDAO> MaxRunBestAvgComparator= Comparator.comparing(field -> field.runs);
            fieldComparatorMap.put(SortByField.MAXIMUM_RUNS_WITH_BEST_AVERAGE, MaxRunBestAvgComparator.thenComparing(field1-> field1.average).reversed());
            fieldComparatorMap.put(SortByField.TOP_BOWLER_AVERAGE, Comparator.comparing(field -> field.Bowler_Average, Comparator.reverseOrder()));
            fieldComparatorMap.put(SortByField.TOP_BOWLERS_STRIK_RATE, Comparator.comparing(field -> field.Bowler_strikeRate, Comparator.reverseOrder()));
            fieldComparatorMap.put(SortByField.BEST_ECOMONY,Comparator.comparing(field->field.Bowler_Economy));
            fieldComparatorMap.put(SortByField.BEST_STRIKING_RATE_WITH_5W_AND_4W,new SortByMaximum4wAnd5w().thenComparing(field -> field.Bowler_strikeRate).reversed());
    }

    public int loadIPLCSVData(String csvFilePath,PlayerType playerType) throws CricketAnalyserException {
        IPLAdapter iplAdapter = IPLAdapterFactory.getIPLPlayer(playerType);
        iplCsvMap= iplAdapter.loadIPLCSVData(csvFilePath);
        return iplCsvMap.size();
    }
    public String sortByFields(SortByField fields) throws CricketAnalyserException {
        if (iplCsvMap == null || iplCsvMap.size() == 0)
        {
            throw new CricketAnalyserException("No IPl Data", CricketAnalyserException.ExceptionType.NO_IPL_DATA);
        }

        ArrayList list =this.iplCsvMap.values().stream()
                .sorted(fieldComparatorMap.get(fields))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplCsvToJson = new Gson().toJson(list);
        return sortIplCsvToJson;
    }

}
