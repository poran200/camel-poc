package restToMongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contries {
    List<Map<String, Object>>  data = new ArrayList<>();

    public Contries() {

    }
    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
