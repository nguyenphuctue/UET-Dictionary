package model;

public class Word {

    /**
     * Attribute.
     */
    private int id;
    private String word_target;
    private String word_explain;

    /**
     *
     * @param id
     * @param word_target
     * @param word_explain
     */
    public Word(int id, String word_target, String word_explain) {
        this.id = id;
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    /**
     * Constructor.
     */
    public Word() {

    }

    /**
     * Method getter.
     */
    public int getId() {
        return id;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    /**
     * Method setter.
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * Method toString.
     */
    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word_target='" + word_target + '\'' +
                ", word_explain='" + word_explain + '\'' +
                '}';
    }

}
