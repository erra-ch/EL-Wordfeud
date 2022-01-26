package se.elserver.ELWordfeud.game.dictionary;

import java.util.HashMap;
import java.util.Map;

public class EnglishWordDictionary extends WordDictionary{

    public EnglishWordDictionary() {
        super.wordMap = setWordMap(); // Don't know how this should be done
    }

    private Map<String, String> setWordMap() {
        return new HashMap<>(
                // Where should this info be?
        );
    }
}
