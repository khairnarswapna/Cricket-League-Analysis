package cricketiplanalyser;

public class IPLDAO {

    public String playerName;
    public int match;
    public double average;
    public double strikeRate;
    public int noOfFours;
    public int noOfSixes;
    public int runs;
    public double Bowler_Average;
    public double Bowler_strikeRate;
    public double Bowler_Economy;
    public int wickets;
    public double overs;
    public int fourWicket;
    public int fiveWicket;

    public IPLDAO(String abc, int i, double v) {
    }

    public IPLDAO(BatsManRunCSV batsManRunCSV) {
        playerName = batsManRunCSV.playerName;
        match = batsManRunCSV.match;
        average = batsManRunCSV.average;
        strikeRate =batsManRunCSV.strikeRate;
        noOfFours=batsManRunCSV.noOfFours;
        noOfSixes=batsManRunCSV.noOfSixes;
        runs=batsManRunCSV.runs;
    }
    public IPLDAO(BowlerWicketCSV bowlerWicketCSV) {

        playerName = bowlerWicketCSV.playerName;
        Bowler_Average= bowlerWicketCSV.Bowler_Average;
        Bowler_strikeRate = bowlerWicketCSV.Bowler_strikeRate;
        Bowler_Economy=bowlerWicketCSV.Bowler_Economy;
        wickets=bowlerWicketCSV.wickets;
        overs=bowlerWicketCSV.overs;
        fourWicket=bowlerWicketCSV.fourWicket;
        fiveWicket=bowlerWicketCSV.fiveWicket;

    }




}
