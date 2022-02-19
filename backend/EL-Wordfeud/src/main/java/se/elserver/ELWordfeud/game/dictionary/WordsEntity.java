package se.elserver.ELWordfeud.game.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "words", schema = "public", catalog = "el-wordfeud")
public class WordsEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Basic
  @Column(name = "word", nullable = false, length = -1)
  private String word;

  @Basic
  @Column(name = "language", nullable = true, length = -1)
  private String language;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WordsEntity that = (WordsEntity) o;
    return id == that.id && Objects.equals(word, that.word) && Objects.equals(language, that.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, word, language);
  }
}
