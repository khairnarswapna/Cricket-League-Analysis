package cricketiplanalyser;

public class CricketAnalyserException extends Exception {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM, FILE_NOT_FOUND, NO_IPL_DATA, SOME_FILE_ISSUE,IPL_CSVFILE_PROBLEM
    }
    ExceptionType type;
    public CricketAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CricketAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
