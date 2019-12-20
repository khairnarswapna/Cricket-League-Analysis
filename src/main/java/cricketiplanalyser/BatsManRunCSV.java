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
    public int runs;
    @CsvBindByName(column = "HS", required = true)
    public String highestScored;
    @CsvBindByName(column = "Avg", required = true)
    public double average;
    @CsvBindByName(column = "BF")
    public int ballFaced;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "100")
    public int noOfHundred;
    @CsvBindByName(column = "50")
    public int noOfFifty;
    @CsvBindByName(column = "4s")
    public int noOfFours;
    @CsvBindByName(column = "6s")
    public int noOfSixes;

    public BatsManRunCSV(BatsManRunCSV batsManRunCSV) {
        this.position = batsManRunCSV.position;
        this.playerName = batsManRunCSV.playerName;
        this.match=batsManRunCSV. match;
        this.innings= batsManRunCSV.innings;
        this.notOut =batsManRunCSV.notOut;
        this.runs= batsManRunCSV.runs;
        this.highestScored =batsManRunCSV.highestScored;
        this.average =batsManRunCSV.average;
        this.ballFaced = batsManRunCSV.ballFaced;
        this.strikeRate =batsManRunCSV.strikeRate;
        this.noOfSixes =batsManRunCSV.noOfHundred;
        this.noOfFifty = batsManRunCSV.noOfFifty;
        this.noOfFours = batsManRunCSV.noOfFours;
        this.noOfSixes = batsManRunCSV.noOfSixes;
    }

}
