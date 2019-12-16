package cricketiplanalyser;

public class IPLRunsDao {

    public String playerName;
    public int match;
    public double average;
    public double strikeRate;
    public int noOfFours;
    public int noOfSixes;

    public IPLRunsDao() {
    }

    public IPLRunsDao(BatsManRunCSV batsManRunCSV) {
        playerName = batsManRunCSV.playerName;
        match = batsManRunCSV.match;
        average = batsManRunCSV.average;
        strikeRate =batsManRunCSV.strikeRate;
        noOfFours=batsManRunCSV.noOfFours;
        noOfSixes=batsManRunCSV.noOfSixes;
    }

}
