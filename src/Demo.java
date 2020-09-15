import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        for (String key:map.keySet()){
            map.put(key, "3");
        }
        int i=0;
    }
}
