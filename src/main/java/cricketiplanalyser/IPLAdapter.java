package cricketiplanalyser;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {

    Map<String, IPLDAO> iplCSVMap ;

    public IPLAdapter() {
        this.iplCSVMap = new HashMap<>();
    }

    public abstract Map<String, IPLDAO> loadIPLCSVData (CricketAnalyser.PlayerType playerType , String ... csvFilePath) throws CricketAnalyserException;

    protected <E> Map<String, IPLDAO> loadIPLCSVData(Class<E> iplClass , String filePath) throws CricketAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVbuilder();
            Iterator<E> censusCSVIterator = csvBuilder.getCSVFileItrator(reader,iplClass);
            Iterable<E> Iterable = () -> censusCSVIterator;
            if (iplClass.getName().equals("cricketiplanalyser.BatsManRunCSV")) {
                StreamSupport.stream(Iterable.spliterator(), false)
                        .map(BatsManRunCSV.class::cast)
                        .forEach(iplCSV -> iplCSVMap .put(iplCSV.playerName, new IPLDAO(iplCSV)));
            }
            else if (iplClass.getName().equals("cricketiplanalyser.BowlerWicketCSV")) {
                StreamSupport.stream(Iterable.spliterator(), false)
                        .map(BowlerWicketCSV.class::cast)
                        .forEach(iplBowlersCSV -> iplCSVMap .put(iplBowlersCSV.playerName, new IPLDAO(iplBowlersCSV)));
            }
            return iplCSVMap;
        } catch (NoSuchFileException e) {
            throw new CricketAnalyserException(e.getMessage(), CricketAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (CSVBuilderException | IOException e) {
            throw new CricketAnalyserException(e.getMessage(), CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

}
