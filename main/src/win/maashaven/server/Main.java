package win.maashaven.server;

import win.maashaven.server.net.NetworkManager;
import win.maashaven.server.utils.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.log("Starting maashaven camera server...");
        Logger.log("Initializing Scoreboard NetworkManager...");

        final NetworkManager scoreboardNetworkMgr = new NetworkManager("localhost", 1337);
        
    }

}
