package se.elserver.ELWordfeud.websocket;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public class PutTile {

  @Getter
  private Character tile;

  @Getter
  private List<Integer> tilePos;
}
