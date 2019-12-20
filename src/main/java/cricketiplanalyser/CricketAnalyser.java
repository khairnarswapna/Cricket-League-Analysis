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

    Map<String, IPLDAO> iplCsvMap = new HashMap<>();
    Map<SortByField, Comparator<IPLDAO>> fieldComparatorMap= null;
    public CricketAnalyser() {
            this.iplCsvMap = new HashMap<>();
            this.fieldComparatorMap= new HashMap<>();
            this.fieldComparatorMap.put(SortByField.AVERAGE, Comparator.comparing(field-> field.average, Comparator.reverseOrder()));
            this.fieldComparatorMap.put(SortByField.STRIKE_RATE,Comparator.comparing(field-> field.strikeRate, Comparator.reverseOrder()));
            this.fieldComparatorMap.put(SortByField.MAXIMUM_SIX_AND_FOUR,new SortByMaximum4SAnd6s());
            this.fieldComparatorMap.put(SortByField.STRIKING_WITH_MAXIMUM_SIXS_AND_FOURS, new SortByMaximum4SAnd6s().reversed().thenComparing(field -> field.strikeRate));
            Comparator<IPLDAO> comparator = Comparator.comparing(field -> field.average);
            this.fieldComparatorMap.put(SortByField.AVERAGE_WITH_STRIKE_RATE, comparator.thenComparing(field-> field.strikeRate).reversed());
            Comparator<IPLDAO> MaxRunBestAvgComparator= Comparator.comparing(field -> field.runs);
            this.fieldComparatorMap.put(SortByField.MAXIMUM_RUNS_WITH_BEST_AVERAGE, MaxRunBestAvgComparator.thenComparing(field1-> field1.average).reversed());

            this.fieldComparatorMap.put(SortByField.TOP_BOWLER_AVERAGE, Comparator.comparing(field -> field.Bowler_Average, Comparator.reverseOrder()));
    }
    public int loadIPLCSVData(String csvFilePath) throws CricketAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder= CSVBuilderFactory.createCSVbuilder();
            Iterator<BatsManRunCSV> iplCSVIterator = csvBuilder.getCSVFileItrator(reader,BatsManRunCSV.class);
            Iterable<BatsManRunCSV> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                     .map(BatsManRunCSV.class::cast)
                    .forEach(iplRuns -> iplCsvMap.put(iplRuns.playerName,new IPLDAO(iplRuns)));
            return iplCsvMap.size();

        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException e){
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        }
    }

    public int loadWicketCSVData(String csvFilePath) throws CricketAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder= CSVBuilderFactory.createCSVbuilder();
            Iterator<BowlerWicketCSV> iplCSVIterator = csvBuilder.getCSVFileItrator(reader,BowlerWicketCSV.class);
            Iterable<BowlerWicketCSV> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .map(BowlerWicketCSV.class::cast)
                    .forEach(ipl -> iplCsvMap.put(ipl.playerName,new IPLDAO(ipl)));
                    return iplCsvMap.size();

        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException e){
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        }
    }

    public String sortbyFields(SortByField fields) throws CricketAnalyserException {
        if (iplCsvMap == null || iplCsvMap.size() == 0)
        {
            throw new CricketAnalyserException("No Census Data", CricketAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        ArrayList list =this.iplCsvMap.values().stream()
                .sorted(fieldComparatorMap.get(fields))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplCsvToJson = new Gson().toJson(list);
        return sortIplCsvToJson;
    }

}
