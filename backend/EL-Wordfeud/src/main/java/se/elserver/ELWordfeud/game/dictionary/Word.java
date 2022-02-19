package se.elserver.ELWordfeud.game.dictionary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
public class Word {

  @Id
  private int id;

  @Column(nullable = false, unique = true)
  private String word;

  @Column(nullable = false, unique = true)
  private String language;

  protected Word() {};

  public Word(String word, String language) {
    this.word = word;
    this.language = language;
  }

  public String getWord() {
    return word;
  }

  public String getLanguage() {
    return language;
  }
}
