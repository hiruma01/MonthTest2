package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
   static Properties pro = null;
    static {
        pro = new Properties();
        InputStream is = DBConfig.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String key){
       String value = pro.getProperty(key);
       return value;
    }
}
