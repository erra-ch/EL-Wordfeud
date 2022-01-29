package se.elserver.ELWordfeud.game.dictionary;

import java.util.Map;

public abstract class WordDictionary {
    /**
     * Map containing words as keys and definitions as values
     */
    protected Map<String, String> wordMap;

    public boolean isValidWord(String word) {
        return this.wordMap.containsKey(word);
    }

    public String getDefinition(String word) {
        return this.wordMap.get(word);
    }
}