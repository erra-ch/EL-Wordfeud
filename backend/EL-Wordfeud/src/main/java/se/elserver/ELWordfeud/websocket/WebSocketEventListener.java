package se.elserver.ELWordfeud.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);

  @Autowired
  private SimpMessageSendingOperations sendingOperations;

  @EventListener
  public void handleWebSocketPlayerConnectListener(final SessionConnectedEvent event) {
    LOGGER.info("A new player has connected to the session");
  }


  @EventListener
  public void handleWebSocketPlayerDisconnectListener(final SessionDisconnectEvent event) {
    final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

    final String username = (String) headerAccessor.getSessionAttributes().get("username");
  }


}
