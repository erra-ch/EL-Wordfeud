package se.elserver.ELWordfeud.game.board;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.elserver.ELWordfeud.game.square.*;
import se.elserver.ELWordfeud.game.tile.Tile;

import java.io.IOException;
import java.nio.file.Paths;

public class StandardBoard extends Board{


    public StandardBoard() {
        super.squareMatrix = new Square[15][15];
        generateSquares();
    }

    @Override
    public void generateSquares() {
        // Works. Probably exists better way
        try {
            ObjectMapper mapper = new ObjectMapper();
            String[][] stringMatrix = mapper.readValue(Paths.get("src/main/resources/StandardBoard.json").toFile(), String[][].class);
            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < 15; col++) {
                    switch (stringMatrix[row][col]) {
                        case "B":
                            squareMatrix[row][col] = new RegularSquare();
                            break;
                        case "DL":
                            squareMatrix[row][col] = new DoubleLetterSquare();
                            break;
                        case "TL":
                            squareMatrix[row][col]= new TripleLetterSquare();
                            break;
                        case "DW":
                            squareMatrix[row][col] = new DoubleWordSquare();
                            break;
                        case "TW":
                            squareMatrix[row][col] = new TripleWordSquare();
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                sb.append(squareMatrix[row][col].toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
