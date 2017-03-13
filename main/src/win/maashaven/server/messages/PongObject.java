package win.maashaven.server.messages;

import java.util.Date;

public class PongObject {

    public long ServerTime = new Date().getTime();
    public String message = "Pong!";
}
