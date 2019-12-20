package cricketiplanalyser;

public class CricketAnalyserException extends Exception {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM, NO_CENSUS_DATA, FILE_NOT_FOUND, SOME_FILE_ISSUE
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
