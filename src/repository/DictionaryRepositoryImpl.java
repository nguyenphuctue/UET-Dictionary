package repository;

import connection.MYSQLConnection;
import model.Word;

import java.io.FileWriter;
import java.io.IOException;
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

    @Override
    public int insertWord(String word_target, String word_explain) {
        int row = 0;
        String query = "INSERT INTO word(word_target, word_explain) VALUE(?, ?)";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, word_target);
            preparedStatement.setString(2, word_explain);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public void exportToFile(List<Word> words) {
        try {
            FileWriter myWriter = new FileWriter("dictionary.txt");
            for (Word w : words) {
                myWriter.write(w.toString() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
