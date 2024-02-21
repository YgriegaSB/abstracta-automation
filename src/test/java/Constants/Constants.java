package Constants;

import java.util.HashMap;

public class Constants {
    public static HashMap<String,String> ENVIRONMENTS = new HashMap<String,String>(){{
        put("DEVELOPMENT","DEVELOPMENT");
        put("PRODUCTION","PRODUCTION");
    }};
    public static HashMap<String,String> BROWSERS = new HashMap<String,String>(){{
        put("CHROME","CHROME");
        put("EDGE","EDGE");
    }};
}
