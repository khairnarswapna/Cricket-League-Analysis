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

    public BowlerWicketCSV(BowlerWicketCSV bowlerWicketCSV) {
        this.pos = bowlerWicketCSV.pos;
        this.playerName = bowlerWicketCSV.playerName;
        this.match =bowlerWicketCSV.match;
        this.innings =bowlerWicketCSV.innings;
        this.overs =bowlerWicketCSV.overs;
        this.runs = bowlerWicketCSV.runs;
        this.wickets =bowlerWicketCSV.wickets;
        this.bbI =bowlerWicketCSV.bbI;
        this.Bowler_Average =bowlerWicketCSV.Bowler_Average;
        this.Bowler_Economy =bowlerWicketCSV.Bowler_Economy;
        this.Bowler_strikeRate =bowlerWicketCSV.Bowler_strikeRate;
        this.fourWicket =bowlerWicketCSV.fourWicket;
        this.fiveWicket =bowlerWicketCSV.fiveWicket;
    }
}
