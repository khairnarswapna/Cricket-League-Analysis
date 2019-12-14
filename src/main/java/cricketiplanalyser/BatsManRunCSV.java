package cricketiplanalyser;

import com.opencsv.bean.CsvBindByName;

public class BatsManRunCSV {
    @CsvBindByName(column ="POS")
    private String POS;

    @CsvBindByName(column = "PLAYER")
    private String PLAYER;

    @CsvBindByName(column = "Mat", required = true)
    private String Mat;

    @CsvBindByName(column = "Inns")
    private String Inns;

    @CsvBindByName(column = "NO", required = true)
    private String NO;

    @CsvBindByName(column = "Runs",required = true)
    private String Runs;

    @CsvBindByName(column = "HS", required = true)
    private String HS;

    @CsvBindByName(column = "Avg", required = true)
    private String Avg;

    @CsvBindByName(column = "BF", required = true)
    private String BF;

    @CsvBindByName(column = "SR", required = true)
    private String SR;

    @CsvBindByName(column = "100" ,required = true)
    private String century;

    @CsvBindByName(column = "50",required = true)
    private String halfCentury;

    @CsvBindByName(column = "4s", required = true)
    private String fours;

    @CsvBindByName(column = "6s",required = true)
    private String sixes;
}
