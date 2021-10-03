package repository;

import model.Word;
import java.util.List;

public interface DictionaryRepository {
    List<Word> getAllWords();
    List<Word> getWordByEnglish(String word_target);
    int insertWord(String word_target, String word_explain);
    void exportToFile(List<Word> words);
}

