package sockets;

import encoder.JsonEncoder;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@ServerEndpoint(value = "/chat", encoders = {JsonEncoder.class})
public class ChatEndpoint {

    @EJB
    private SessionRegistry sessionRegistry = new SessionRegistry();

    @OnOpen
    public void open(Session session, EndpointConfig conf) throws IOException {
        sessionRegistry.add(session);
        session.getBasicRemote().sendText("Hi!");
    }

    @OnMessage
    public void onMessage(String message, Session sender) throws IOException {
        Set<Session> sessions = sessionRegistry.getAll();
        for (Session s : sessions) {
            try {
//                String myJSONString = "{'test': '100.00'}";
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("id", sender.getId());
//                jsonObject.addProperty("message", message);
//                jsonObject.addProperty("time", LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")));
//                s.getBasicRemote().sendObject(
//                        new Gson().fromJson(myJSONString, JsonObject.class)
//                );
                JsonObject event = Json.createObjectBuilder()
                        .add("mes", message)
                        .add("id", sender.getId())
                        .add("time_sent", LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")))
                        .build();
                s.getBasicRemote().sendObject(event);
            } catch (EncodeException e) {
                e.printStackTrace();
            }
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
