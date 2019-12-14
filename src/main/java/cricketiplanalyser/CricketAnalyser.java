package cricketiplanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CricketAnalyser {

    public int loadCSVData(String csvFilePath) throws CricketAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<BatsManRunCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(BatsManRunCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<BatsManRunCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<BatsManRunCSV> censusCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEateries++;
                BatsManRunCSV censusData = censusCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

}
