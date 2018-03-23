package sockets;

import javax.ejb.EJB;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    @EJB
    private SessionRegistry sessionRegistry;

    @OnOpen
    public void open(Session session, EndpointConfig conf) throws IOException {
        sessionRegistry.add(session);
        session.getBasicRemote().sendText("Hi!");
    }

    @OnMessage
    public void onMessage(String message, Session sender) throws IOException {
        System.out.println("@@@@@@@@@@@" + message);
        Set<Session> sessions = sessionRegistry.getAll();
        for (Session s : sessions) {
            s.getBasicRemote().sendText(
                    "USER WITH ID: " + sender.getId() +
                            " said " + message
            );
        }
    }

    @OnClose
    public void close(Session session) {
        sessionRegistry.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
    }
}
