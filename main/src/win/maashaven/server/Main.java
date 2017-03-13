package win.maashaven.server;

import win.maashaven.server.net.NetworkManager;
import win.maashaven.server.net.PacketHandler;
import win.maashaven.server.utils.Logger;

public class Main {

    private static NetworkManager scoreboardNetworkMgr;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(
                new Thread("app-shutdown-hook") {
                    @Override
                    public void run() {
                        scoreboardNetworkMgr.kill();
                        System.out.println("goodbye fuckers");

                    }
                });

        Logger.log("Starting maashaven camera server...");
        Logger.log("Initializing Scoreboard NetworkManager...");

        scoreboardNetworkMgr = new NetworkManager("localhost", 6001);
        scoreboardNetworkMgr.attachPacketHandler(new PacketHandler());
    }

}
