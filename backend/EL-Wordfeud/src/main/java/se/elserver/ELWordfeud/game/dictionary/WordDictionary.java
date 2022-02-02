package se.elserver.ELWordfeud.game.dictionary;

import java.util.Map;

public abstract class WordDictionary {
    /**
     * Map containing words as keys and definitions as values
     */
    protected Map<String, String> wordMap;

    public abstract boolean isValidWord(String word);

    public abstract String getDefinition(String word);
}
