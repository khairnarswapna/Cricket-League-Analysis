package cricketiplanalyser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class SortbyField {

    public Map<Field, Comparator> sortByFields = new HashMap<>();
    public enum Field {
        AVERAGE
    }
    public SortbyField() {
        sortByFields.put( Field.AVERAGE, Comparator.<BatsManRunCSV,Double>comparing(census -> (census.average),Comparator.reverseOrder()));
    }

    public Comparator getParameter( Field field) {
        Comparator<BatsManRunCSV> comparator = sortByFields.get(field);
        return comparator;
    }
}
