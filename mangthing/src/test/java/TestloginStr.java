import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Fansghuai on 2016/1/29.
 */
public class TestloginStr extends TestCase {

    public void testlogin() {
        String api_key = "libaixiyige";
        String key = "woshiyeshou";
        String cm_flag = "0";
        String server_id = "1";
        Long times = new DateTime().getMillis();
        String timestamp = String.valueOf(times);
        String user_id = "fs";

        StringBuilder sb = new StringBuilder(256);
        sb.append(key).append("api_key").append(api_key).append("cm_flag")
                .append(cm_flag).append("server_id").append(server_id)
                .append("timestamp").append(timestamp).append("user_id")
                .append(user_id);

        DateTimeFormatter formatter = DateTimeFormat
                .forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.print(formatter.parseMillis(timestamp));
    }

    public void testJianR() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (143 * i + 126 * j <= 200 && 4 * i + 4 * j <= 800
                        && 13 * i + 8 * j <= 7000 && 50 * i + 65 * j < 8000
                        && 40 * i + 13 * j < 6000) {
                    System.out.println(i + " " + j + " " + (i + j));
                }
            }
        }
    }

    public void test() {
        int page = 3;
        int startIndex = page * 20;
        int len = Math.min(startIndex + 20, 50);
        int start = len / 20 * 20;
        System.out.println(start);
    }
}
