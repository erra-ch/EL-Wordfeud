package se.elserver.ELWordfeud.game.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

  @Autowired
  private WordRepository wordRepository;

  public boolean isWordValid(String word) {
    return wordRepository.existsByWord(word);
  }
}
