package cricketiplanalyser;

public class IPLAdapterFactory {

    public static IPLAdapter getIPLPlayer(CricketAnalyser.PlayerType playertype) {
        if(playertype.equals(CricketAnalyser.PlayerType.IPL_BATSMAN_RUNS))
            return new BatsManRunsAdapter();
        return new BowlerWicketAdapter();
    }

}
