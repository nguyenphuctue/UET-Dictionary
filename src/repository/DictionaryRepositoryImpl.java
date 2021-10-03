package repository;

import connection.MYSQLConnection;
import model.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryRepositoryImpl implements DictionaryRepository {
    @Override
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        String query = "SELECT * FROM word";

        try (Connection connection = MYSQLConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getInt(1));
                word.setWord_target(rs.getString(2));
                word.setWord_explain(rs.getString(3));
                words.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return words;
    }

    @Override
    public List<Word> getWordByEnglish(String word_target) {
        List<Word> words = new ArrayList<>();
        String query = "SELECT * FROM word WHERE word_target LIKE ?";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, word_target + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getInt(1));
                word.setWord_target(rs.getString(2));
                word.setWord_explain(rs.getString(3));
                words.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return words;
    }
}
