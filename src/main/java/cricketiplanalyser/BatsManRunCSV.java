package cricketiplanalyser;
import com.opencsv.bean.CsvBindByName;

public class BatsManRunCSV {

    public BatsManRunCSV() {
    }
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER")
    public String playerName;
    @CsvBindByName(column = "Mat")
    public int match;
    @CsvBindByName(column = "Inns")
    public int innings;
    @CsvBindByName(column = "NO")
    public int notOut;
    @CsvBindByName(column = "Runs")
    public int runs;
    @CsvBindByName(column = "HS")
    public String highestScored;
    @CsvBindByName(column = "Avg")
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
