package se.elserver.ELWordfeud.websocket;

import lombok.Builder;
import lombok.Getter;

@Builder
public class PlayerActionMessage {

  @Getter
  private ActionType action;

  @Getter
  private String username;

  @Getter
  private String time;

  @Getter
  private PutTile putTile;
}
