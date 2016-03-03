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

}
