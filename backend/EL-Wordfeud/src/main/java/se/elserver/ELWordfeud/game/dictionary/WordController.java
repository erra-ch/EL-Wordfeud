package se.elserver.ELWordfeud.game.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Temporary!!!
@RestController
public class WordController {

  @Autowired
  private WordService wordService;

  @Autowired
  private WordRepository wordRepository;


  @GetMapping("word/all")
  List<Word> findAll() {
    return wordRepository.findAll();
  }


  @GetMapping("word/{w}")
  boolean isWordValid(@PathVariable String w) {
    return wordService.isWordValid(w);
  }
}

