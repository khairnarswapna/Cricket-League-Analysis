package cricketiplanalyser;
import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class CricketAnalyser {

    public int loadCSVData(String csvFilePath) throws CricketAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder= CSVBuilderFactory.createCSVbuilder();
            Iterator<BatsManRunCSV> iplCSVIterator = csvBuilder.getCSVFileItrator(reader, BatsManRunCSV.class);
            Iterable<BatsManRunCSV> csvIterable = () -> iplCSVIterator;
            int CricketerCount = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return CricketerCount;
        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException e){
            throw new CricketAnalyserException(e.getMessage(),CricketAnalyserException.ExceptionType.SOME_FILE_ISSUE);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
