package win.maashaven.server.net;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class NetworkManager {

    private Configuration config = new Configuration();
    private final SocketIOServer server;

    public NetworkManager(String hostname, int port) {
        config.setHostname(hostname);
        config.setPort(port);
        this.config = config;

        this.server = new SocketIOServer(config);
        server.start();
    }

    public void attachPacketHandler() {

    }

    /**
     * Returns the socket.io instance in this NetworkManager.
     * @return socket.io instance.
     */
    public SocketIOServer getServer() {
        return server;
    }

    /**
     * Returns the hostname this manager is listening on.
     * @return the hostname
     */
    public String getHostname() {
        return this.config.getHostname();
    }

    /**
     * Returns the port this manager is listening on.
     * @return the port
     */
    public int getPort() {
        return this.config.getPort();
    }
}
