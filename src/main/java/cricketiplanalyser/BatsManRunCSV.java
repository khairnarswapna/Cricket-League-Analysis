package cricketiplanalyser;
import com.opencsv.bean.CsvBindByName;

public class BatsManRunCSV {

    public BatsManRunCSV() {
    }
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;
    @CsvBindByName(column = "Mat", required = true)
    public int match;
    @CsvBindByName(column = "Inns", required = true)
    public int innings;
    @CsvBindByName(column = "NO", required = true)
    public int notOut;
    @CsvBindByName(column = "Runs", required = true)
    public int runsScored;
    @CsvBindByName(column = "HS", required = true)
    public String highestScored;
    @CsvBindByName(column = "Avg", required = true)
    public double average;
    @CsvBindByName(column = "BF")
    public int ballFaced;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "100")
    public int noOfHundredScored;
    @CsvBindByName(column = "50")
    public int noOfFiftyScored;
    @CsvBindByName(column = "4s")
    public int noOfFourScored;
    @CsvBindByName(column = "6s")
    public int noOfSixesScored;

    public BatsManRunCSV(BatsManRunCSV batsManRunCSV) {
        this.position = batsManRunCSV.position;
        this.playerName = batsManRunCSV.playerName;
        this.match=batsManRunCSV. match;
        this.innings= batsManRunCSV.innings;
        this.notOut =batsManRunCSV.notOut;
        this.runsScored = batsManRunCSV.runsScored;
        this.highestScored =batsManRunCSV.highestScored;
        this.average =batsManRunCSV.average;
        this.ballFaced = batsManRunCSV.ballFaced;
        this.strikeRate =batsManRunCSV.strikeRate;
        this.noOfSixesScored =batsManRunCSV.noOfHundredScored;
        this.noOfFiftyScored = batsManRunCSV.noOfFiftyScored;
        this.noOfFourScored = batsManRunCSV.noOfFourScored;
        this.noOfSixesScored = batsManRunCSV.noOfSixesScored;
    }
}
