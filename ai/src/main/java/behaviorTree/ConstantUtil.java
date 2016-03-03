package behaviorTree;

/**
 * Created by Fangshuai on 2016/3/1.
 */
public class ConstantUtil {
    private static boolean printInfoFlag = false;

    public static void logPrint(String info) {
        if (printInfoFlag)
            System.out.println(info);
    }
}
