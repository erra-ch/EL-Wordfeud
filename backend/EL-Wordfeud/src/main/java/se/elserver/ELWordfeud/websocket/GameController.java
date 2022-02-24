package se.elserver.ELWordfeud.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

  @MessageMapping("/game.newPlayer")
  @SendTo("/topic/game")
  public PlayerActionMessage newPlayer(@Payload final PlayerActionMessage playerActionMessage,
                                     SimpMessageHeaderAccessor headerAccessor) {

    headerAccessor.getSessionAttributes().put("username", playerActionMessage.getUsername());
    return playerActionMessage;
  }

  @MessageMapping("/game.putTile")
  @SendTo("/topic/game")
  public PlayerActionMessage putTile(@Payload final PlayerActionMessage playerActionMessage,
                                     SimpMessageHeaderAccessor headerAccessor) {

    headerAccessor.getSessionAttributes().put("putTile", playerActionMessage.getPutTile());
    return playerActionMessage;
  }

}
