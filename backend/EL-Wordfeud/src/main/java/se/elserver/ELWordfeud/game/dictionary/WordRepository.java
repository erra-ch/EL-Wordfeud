package se.elserver.ELWordfeud.game.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository <Word, Long> {

  //@Query(value = "SELECT w FROM Dictionary w WHERE w.word = :word")
  public boolean existsByWord(String word);

  public List<Word> findAll();
}
