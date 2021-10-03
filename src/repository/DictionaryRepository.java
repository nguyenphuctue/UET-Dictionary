package repository;

import model.Word;
import java.util.List;

public interface DictionaryRepository {
    List<Word> getAllWords();
    List<Word> getWordByEnglish(String word_target);
}
