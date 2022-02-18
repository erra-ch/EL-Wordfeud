package se.elserver.ELWordfeud.game.tile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class SwedishTileBag extends TileBag{

    public SwedishTileBag() {
        super(new ArrayList<>(104)); // I donnu bruv. Vet inte hur man borde ha de
        super.tiles = fillTileBag();
        Collections.shuffle(super.tiles);
    }

    private List fillTileBag() {
        ArrayList tiles = new ArrayList<>(104);
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<JSONTile> jsonTiles = Arrays.asList(mapper.readValue(Paths.get("src/main/resources/SwedishTileBag.json").toFile(), JSONTile[].class));
            for (JSONTile tile : jsonTiles) {
                for (int i = 0; i < tile.getAmount(); i++) {

                    if (tile.getLetter().equals(" ")) {
                        tiles.add(new BlankTile(tile.getLetter(), tile.getPoints()));
                    } else {
                        tiles.add(new NormalTile(tile.getLetter(), tile.getPoints()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }
}
