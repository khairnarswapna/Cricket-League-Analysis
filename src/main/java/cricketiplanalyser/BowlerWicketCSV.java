package cricketiplanalyser;

import com.opencsv.bean.CsvBindByName;

public class BowlerWicketCSV {

    @CsvBindByName(column = "POS")
    public int pos;
    @CsvBindByName(column = "PLAYER")
    public String playerName;
    @CsvBindByName(column = "Mat")
    public int match;
    @CsvBindByName(column = "Inns")
    public int innings;
    @CsvBindByName(column = "Ov")
    public double overs;
    @CsvBindByName(column = "Runs")
    public int runs;
    @CsvBindByName(column = "Wkts")
    public int wickets;
    @CsvBindByName(column = "BBI")
    public String bbI;
    @CsvBindByName(column = "Avg")
    public double Bowler_Average;
    @CsvBindByName(column = "Econ")
    public double  Bowler_Economy;
    @CsvBindByName(column = "SR")
    public double Bowler_strikeRate;
    @CsvBindByName(column = "4w")
    public int fourWicket;
    @CsvBindByName(column = "5w")
    public int fiveWicket;

    public BowlerWicketCSV() {
    }

    public BowlerWicketCSV(int pos, String playerName, int match, int innings, double overs, int runs, int wickets, String bbI, double bowler_Average, double bowler_Economy, double bowler_strikeRate, int fourWicket, int fiveWicket) {
        this.pos = pos;
        this.playerName = playerName;
        this.match = match;
        this.innings = innings;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        this.bbI = bbI;
        this.Bowler_Average = bowler_Average;
        this.Bowler_Economy = bowler_Economy;
        this.Bowler_strikeRate = bowler_strikeRate;
        this.fourWicket = fourWicket;
        this.fiveWicket = fiveWicket;
    }
}
