package win.maashaven.server.net;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import win.maashaven.server.messages.PingObject;
import win.maashaven.server.messages.PongObject;
import win.maashaven.server.utils.Logger;

public class PacketHandler {

    private SocketIOServer server;

    void setSocket(SocketIOServer server) {
        this.server = server;
        this.registerPackets();
    }

    private void registerPackets() {
        server.addConnectListener(new ConnectListener() {
           public void onConnect(SocketIOClient client) {
                Logger.log("Client connected: " + client.getRemoteAddress());
               server.getBroadcastOperations().sendEvent("pong", new PongObject());
           }
        });

        server.addEventListener("ping", PingObject.class, new DataListener<PingObject>() {
            public void onData(SocketIOClient socketIOClient, PingObject pingObject, AckRequest ackRequest) throws Exception {
                Logger.log("client Pinged us");
                server.getBroadcastOperations().sendEvent("pong", new PongObject());
            }
        });

    }

}
