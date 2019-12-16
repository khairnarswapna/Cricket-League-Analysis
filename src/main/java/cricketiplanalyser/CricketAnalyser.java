package cricketiplanalyser;
import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalyser {

    Map<String,BatsManRunCSV> iplRunsCsvMap = new HashMap<>();
    Map<SortByField, Comparator<BatsManRunCSV>> fieldComparatorMap= null;
    public CricketAnalyser() {
            this.iplRunsCsvMap = new HashMap<>();
            this.fieldComparatorMap= new HashMap<>();
            this.fieldComparatorMap.put(SortByField.AVERAGE, Comparator.comparing(census -> census.average, Comparator.reverseOrder()));
    }
    public<E> Map<String, BatsManRunCSV> loadIPLCSVData(String csvFilePath) throws CricketAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder= CSVBuilderFactory.createCSVbuilder();
            Iterator<BatsManRunCSV> iplCSVIterator = csvBuilder.getCSVFileItrator(reader,BatsManRunCSV.class);
            Iterable<BatsManRunCSV> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                     .map(BatsManRunCSV.class::cast)
                    .forEach(iplRuns -> this.iplRunsCsvMap.put(iplRuns.playerName,iplRuns));
            return iplRunsCsvMap;

        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException e){
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        }
    }
    public String sortbyFields(SortByField feilds) throws CricketAnalyserException {
        if (iplRunsCsvMap == null || iplRunsCsvMap.size() == 0)
        {
            throw new CricketAnalyserException("No Census Data", CricketAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        ArrayList list = this.iplRunsCsvMap.values().stream()
                .sorted(this.fieldComparatorMap.get(feilds))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplCsvToJson = new Gson().toJson(list);
        return sortIplCsvToJson;
    }

}
