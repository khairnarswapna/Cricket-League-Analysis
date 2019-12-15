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
    public CricketAnalyser() {
        this.iplRunsCsvMap = new HashMap<>();
    }
    public Map loadIPLCSVData(String csvFilePath) throws CricketAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder= CSVBuilderFactory.createCSVbuilder();
            Iterator<BatsManRunCSV> iplCSVIterator = csvBuilder.getCSVFileItrator(reader, BatsManRunCSV.class);
            Iterable<BatsManRunCSV> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .map(BatsManRunCSV.class::cast)
                    .forEach(iplRuns -> this.iplRunsCsvMap.put(iplRuns.playerName, iplRuns));
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
    public String sortbyFields(SortbyField.Field feild) {
        Comparator<BatsManRunCSV> iplComparator = new SortbyField().getParameter(feild);
        ArrayList<BatsManRunCSV> list = this.iplRunsCsvMap.values().stream()
                .sorted(iplComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(list);
        return sortIplToJson;
    }

}
