package win.maashaven.server.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public static void getDateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("[HH:mm:ss] ");
        log(dateFormat.format(new Date()));
    }

    public static void log(String str) {
        System.out.println(str);
    }
}
